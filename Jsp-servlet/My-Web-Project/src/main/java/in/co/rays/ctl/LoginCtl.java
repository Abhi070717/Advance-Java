package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		System.out.println("op === " + op);

		if (op != null) {
			HttpSession session = request.getSession();
			session.invalidate(); // session destroy
			request.setAttribute("successMsg", "user logout successfully");
		}

		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		String op = request.getParameter("operation");
		if (op.equals("signUp")) {
			response.sendRedirect("UserRegistrationctl");
		}

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		bean.setLogin(login);
		bean.setPassword(password);

		HttpSession session = request.getSession();

		try {
			bean = model.authenticate(bean.getLogin(), bean.getPassword());
			if (bean != null) {
				System.out.println("user login successfully");
				session.setAttribute("user", bean);
				response.sendRedirect("WelcomeCtl");
			} else {
				System.out.println("invalid login or password");
			}
		} catch (Exception e) {
		}

	}
}
