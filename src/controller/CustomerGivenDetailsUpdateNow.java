package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Customer_Cart;
import model.CustomerUpdateDetailsNowModel;

/**
 * Servlet implementation class CustomerGivenDetailsUpdateNow
 */
@WebServlet("/CustomerGivenDetailsUpdateNow")
public class CustomerGivenDetailsUpdateNow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerGivenDetailsUpdateNow() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("id=>"+id);
		String email=request.getParameter("email");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String address1=request.getParameter("address1");
		String address2=request.getParameter("address2");
		String postalcode=request.getParameter("postalcode");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String mobilenumber=request.getParameter("mobilenumber");
		String password=request.getParameter("password");
		
		Customer_Cart cc=new Customer_Cart();
		cc.setCustomerid(id);
		cc.setEmail(email);
		cc.setFirstname(firstname);
		cc.setLastname(lastname);
		cc.setAddress1(address1);
		cc.setAddress2(address2);
		cc.setPostalcode(postalcode);
		cc.setCity(city);
		cc.setState(state);
		cc.setMobilenumber(mobilenumber);
		cc.setPassword(password);
		
		System.out.println("CustomerUpdateDetailsNowModel().updateDetails(cc);---->");
		int x=new CustomerUpdateDetailsNowModel().updateDetails(cc);
		if(x!=0)
		{
			rd=request.getRequestDispatcher("customerhome.jsp");
			request.setAttribute("updatedcustomer", "Details Successfully updated");
			rd.forward(request, response);
		}
		else
		{
			rd=request.getRequestDispatcher("customerhome.jsp");
			request.setAttribute("updatedcustomer", "Details not updated!!!!!!!");
			rd.include(request, response);
		}
		
	}

}
