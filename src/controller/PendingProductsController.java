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
import beans.Product;
import model.ShowCartModel;
import model.ViewProductsModel;

/**
 * Servlet implementation class PendingProductsController
 */
@WebServlet("/PendingProductsController")
public class PendingProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PendingProductsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
RequestDispatcher rd;
	
//		HttpSession ht=request.getSession();
//		String ipaddressfromindex=(String)ht.getAttribute("ipaddressfromindex");
//		ArrayList<Cart> al=new ViewProductsModel().getData(ipaddressfromindex);
//	
	HttpSession ht=request.getSession();
	String ipaddress1=(String)ht.getAttribute("client_ipaddress");
	ArrayList<Cart> al=(ArrayList<Cart>)new ShowCartModel().getCartData(ipaddress1);
		if(al!=null) {
			rd=request.getRequestDispatcher("viewpendingproductstocustomer.jsp");
			request.setAttribute("unorderedproducts", al);
			rd.forward(request, response);
		}
		else
		{
			rd=request.getRequestDispatcher("viewpendingproductstocustomer.jsp");
			request.setAttribute("unorderedproducts","Sorry! no data found about loan");
			rd.include(request, response);
		}
	}

}
