package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminChangePasswordModel;
import model.CustomerChangePasswordModel;

/**
 * Servlet implementation class AdminChangePasswordController
 */
@WebServlet("/AdminChangePasswordController")
public class AdminChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangePasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldpassword=request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");
		String confirmpassword=request.getParameter("confirmpassword");
		
		HttpSession ht=request.getSession();
		
		String adminid=(String)ht.getAttribute("adminid");
		System.out.println("AdminChangePasswordController->=");
		RequestDispatcher rd=null;
		int x=0;
		if(newpassword.equals(confirmpassword))
			x=new AdminChangePasswordModel().changePassword(adminid,confirmpassword);
		
		if(x==1)
		{
			rd=request.getRequestDispatcher("adminhome.jsp");
			request.setAttribute("changingadminpassword", "password changed");
			rd.forward(request, response);
		}
		else
		{
			rd=request.getRequestDispatcher("customerhome.jsp");
			request.setAttribute("changingadminpassword", "not able to change password");
			rd.include(request, response);
		}
	}

}
