package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SignUpCustomerModel;

/**
 * Servlet implementation class CustomerLoginController
 */
@WebServlet("/CustomerLoginController")
public class CustomerLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			RequestDispatcher rd=null;
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			HttpSession ht=request.getSession();
			ht.setAttribute("customer_email(session)", email);
			String customerfromindex=(String)ht.getAttribute("customerfromindex");
			if(customerfromindex.equals("id"))
			{
						int x=new SignUpCustomerModel().check(email,password);
						if(x==1)
						{
							String ipaddressfromindex=request.getRemoteAddr();
							ht.setAttribute("ipaddressfromindex", ipaddressfromindex);
							ht.setAttribute("customersession", email);
							rd=request.getRequestDispatcher("customerhome.jsp");
							request.setAttribute("customerlogin","Customer login successful... ");
							rd.forward(request,response);
						}
						else
						{
							rd=request.getRequestDispatcher("customerloginfromindex.jsp");
							request.setAttribute("customerlogin","login failed..");
							rd.include(request,response);
						}
			}
			else
			{
				int x=new SignUpCustomerModel().check(email,password);
				if(x==1)
				{
					rd=request.getRequestDispatcher("customerhome.jsp");
					request.setAttribute("customerlogin","Customer login successful... ");
					rd.forward(request,response);
				}
				else
				{
					rd=request.getRequestDispatcher("customerlogin.jsp");
					request.setAttribute("customerlogin","login failed..");
					rd.include(request,response);
				}
			}
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
