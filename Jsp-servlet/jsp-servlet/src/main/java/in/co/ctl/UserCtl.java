package in.co.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.bean.UserBean;
import in.co.model.UserModel;

@WebServlet("/UserCtl.do")
public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserModel model = new UserModel();

		String id = request.getParameter("id");

		if (id != null) {
			try {
				UserBean bean = model.findByPk(Integer.parseInt(id));
				request.setAttribute("bean", bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("int do post method");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		String op = request.getParameter("operation");

		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String DOB = request.getParameter("DOB");
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		try {
			bean.setFirstName(fname);
			bean.setLastName(lname);
			bean.setLogin(login);
			bean.setPassword(password);
			bean.setDob(sdf.parse(DOB));

			if (op.equals("update")) {
				bean.setId(Integer.parseInt(request.getParameter("id")));
				model.update(bean);
				System.out.println("user added successfully");
				request.setAttribute("successMsg", "user updated successfully");
			} else {
				model.add(bean);
				System.out.println("user added successfully");
				request.setAttribute("successMsg", "user added successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp");
		rd.forward(request, response);

	}

}
