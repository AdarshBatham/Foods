package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerChangePasswordModel;

/**
 * Servlet implementation class CustomerChangePasswordController
 */
@WebServlet("/CustomerChangePasswordController")
public class CustomerChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerChangePasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldpassword=request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");
		String confirmpassword=request.getParameter("confirmpassword");
		
		HttpSession ht=request.getSession();
		String email=(String)ht.getAttribute("customer_email(session)");
		System.out.println("CustomerChangePasswordController->emailid="+email);
		RequestDispatcher rd=null;
		int x=0;
		if(newpassword.equals(confirmpassword))
			x=new CustomerChangePasswordModel().changePassword(email,confirmpassword);
		
		if(x==1)
		{
			rd=request.getRequestDispatcher("customerhome.jsp");
			request.setAttribute("changingcustomerpassword", "password changed");
			rd.forward(request, response);
		}
		else
		{
			rd=request.getRequestDispatcher("customerhome.jsp");
			request.setAttribute("changingcustomerpassword", "not able to change password");
			rd.include(request, response);
		}
	}

}
