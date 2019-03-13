package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Customer;
import model.SignUpCustomerModel;

/**
 * Servlet implementation class SignUpCustomerController
 */
@WebServlet("/SignUpCustomerController")
public class SignUpCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpCustomerController() {
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
			RequestDispatcher rd=null;
			HttpSession ht=request.getSession();
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			String mobilenumber=request.getParameter("mobilenumber");
			String password=request.getParameter("password");
			
			
			
			
			Customer c1=new Customer();
			c1.setName(name);
			c1.setAddress(address);
			c1.setMobilenumber(mobilenumber);
			c1.setPassword(password);
			int x=new SignUpCustomerModel().insertData(c1);
			
			if(x==1)
			{
				rd=request.getRequestDispatcher("index.jsp");
				request.setAttribute("newcustomerinserted", "Congratulations data inserted");
				rd.forward(request, response);
			}
			else
			{
				rd=request.getRequestDispatcher("customersignup.jsp");
				request.setAttribute("newcustomernotinserted", "insertion failed!!!!");
				rd.include(request, response);
			}
	}

}
