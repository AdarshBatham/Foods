package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cart;
import model.ShowCartModel;

/**
 * Servlet implementation class GoBackToShowCartController
 */
@WebServlet("/GoBackToShowCartController")
public class GoBackToShowCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoBackToShowCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ht=request.getSession();
		String ipaddress1=(String)ht.getAttribute("client_ipaddress");
		ArrayList<Cart> al1=(ArrayList<Cart>)new ShowCartModel().getCartData(ipaddress1);
		
		ht.setAttribute("buyproducts",al1);//  setting session because data will be inserted into the buytable at the time of chicking out, corresponding to ipaddress
		
		if(al1!=null)
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("showcart.jsp");
			
			request.setAttribute("cartlist",al1);
			
			rd.forward(request,response);
			
		}
	}

}
