package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Customer_Cart;
import model.CustomerUpdateProfileModel;

/**
 * Servlet implementation class CustomerUpdateProfileController
 */
@WebServlet("/CustomerUpdateProfileController")
public class CustomerUpdateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateProfileController() {
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
		
	RequestDispatcher rd;
		
		HttpSession ht=request.getSession();
		String email=(String)ht.getAttribute("customer_email(session)");
		
		Customer_Cart cc=new CustomerUpdateProfileModel().getDetails(email);
			if(cc!=null) {
				rd=request.getRequestDispatcher("customerupdateprofile.jsp");
				request.setAttribute("customerupdateprofile(Details)", cc);
				rd.forward(request, response);
			}
			else
			{
				rd=request.getRequestDispatcher("customerupdateprofile.jsp");
				request.setAttribute("customerupdateprofile(Details)","Sorry! no data found about loan");
				rd.include(request, response);
			}
	}

}
