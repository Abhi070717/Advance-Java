package in.co.rays.MarksheetDetailClt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

	    String name = request.getParameter("Name");
	    String rollNoStr = request.getParameter("RollNo");
	    String userCaptcha = request.getParameter("captchaInput");

	    HttpSession session = request.getSession(false);
	    String sessionCaptcha = (session != null) 
	            ? (String) session.getAttribute("captcha") 
	            : null;

	    if (sessionCaptcha == null || userCaptcha == null
	            || !sessionCaptcha.equalsIgnoreCase(userCaptcha.trim())) {

	        request.setAttribute("error", "Invalid CAPTCHA. Please try again.");
	        RequestDispatcher rd = request.getRequestDispatcher("StudentLogin.jsp");
	        rd.forward(request, response);
	        return;
	    }

	    session.removeAttribute("captcha");

	    try {

	        int rollNo = Integer.parseInt(rollNoStr);

	        MarksheetModel model = new MarksheetModel();
	        MarksheetBean bean = model.findByRollNo(rollNo);

	        if (bean != null && bean.getName().equalsIgnoreCase(name)) {

	            request.setAttribute("bean", bean);
	            RequestDispatcher rd = request.getRequestDispatcher("WelcomeView.jsp");
	            rd.forward(request, response);

	        } else {

	            request.setAttribute("Error", "Invalid Name or Roll Number.");
	            RequestDispatcher rd = request.getRequestDispatcher("StudentLogin.jsp");
	            rd.forward(request, response);
	        }

	    } catch (NumberFormatException e) {

	        request.setAttribute("Error", "Roll Number must be numeric.");
	        RequestDispatcher rd = request.getRequestDispatcher("StudentLogin.jsp");
	        rd.forward(request, response);

	    } catch (Exception e) {

	        e.printStackTrace();
	        request.setAttribute("Error", "Server Error!");
	        RequestDispatcher rd = request.getRequestDispatcher("StudentLogin.jsp");
	        rd.forward(request, response);
	    }
	}
}
