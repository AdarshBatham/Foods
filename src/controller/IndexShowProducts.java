package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cart;
import beans.Product;
import model.ViewProductsModel;

/**
 * Servlet implementation class IndexShowProducts
 */
@WebServlet("/IndexShowProducts")
public class IndexShowProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexShowProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ht=request.getSession();
		String adminid=(String)ht.getAttribute("adminid");
		RequestDispatcher rd;
		
		String ii=request.getRemoteAddr();
		
		ArrayList<Product> al=new ViewProductsModel().getData();
		if(al!=null) {
			ArrayList<Cart> calculated_values=new ViewProductsModel().calculateValues(ii);
			rd=request.getRequestDispatcher("indexshowproducts2.jsp");
			request.setAttribute("calculated_values", calculated_values);
			request.setAttribute("arraylist", al);
			rd.forward(request, response);
		}
		else
		{
			rd=request.getRequestDispatcher("indexshowproducts1.jsp");
			request.setAttribute("nodatafound","Sorry! no data found about loan");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
