package in.co.rays.MarksheetDetailClt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.MarksheetModel.MarksheetModel;
import in.co.rays.bean.MarksheetBean;

@WebServlet("/MarksheetLoginCtl")
public class MarksheetLoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("operation");

		if (op != null) {
			HttpSession session = request.getSession();
			session.invalidate();
		}
		response.sendRedirect("MarksheetLoginView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		String name = request.getParameter("Name");
		String rollNo = request.getParameter("RollNo");
		String userCaptcha = request.getParameter("captchaInput");

		HttpSession session = request.getSession();
		String sessionCaptcha = (String) session.getAttribute("captcha");

		if (sessionCaptcha == null || !sessionCaptcha.equalsIgnoreCase(userCaptcha)) {

			request.setAttribute("error", "Invalid CAPTCHA. Please try again.");
			request.getRequestDispatcher("StudentLogin.jsp").forward(request, response);
			return;
		}

		if ("John".equalsIgnoreCase(name) && "101".equals(rollNo)) {

			request.getRequestDispatcher("Marksheet.jsp").forward(request, response);

		} else {

			request.setAttribute("error", "Invalid Name or Roll Number.");
			request.getRequestDispatcher("StudentLogin.jsp").forward(request, response);
		}
	}
}
