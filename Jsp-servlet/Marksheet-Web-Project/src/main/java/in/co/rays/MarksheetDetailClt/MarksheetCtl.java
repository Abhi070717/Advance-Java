package in.co.rays.MarksheetDetailClt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import in.co.rays.MarksheetModel.MarksheetModel;
import in.co.rays.bean.MarksheetBean;

@WebServlet("/MarksheetCtl")
public class MarksheetCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rollNoStr = request.getParameter("RollNo");

		if (rollNoStr == null || rollNoStr.trim().isEmpty()) {
			response.sendRedirect("StudentLogin.jsp");
			return;
		}

		try {

			int rollNo = Integer.parseInt(rollNoStr);

			MarksheetModel model = new MarksheetModel();
			MarksheetBean bean = model.findByRollNo(rollNo);

			if (bean != null) {

				request.setAttribute("bean", bean);
				request.getRequestDispatcher("MarksheetView.jsp").forward(request, response);

			} else {

				request.setAttribute("Error", "No record found.");
				request.getRequestDispatcher("StudentLogin.jsp").forward(request, response);
			}

		} catch (NumberFormatException e) {

			request.setAttribute("Error", "Roll Number must be numeric.");
			request.getRequestDispatcher("StudentLogin.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("Error", "Server Error!");
			request.getRequestDispatcher("StudentLogin.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
