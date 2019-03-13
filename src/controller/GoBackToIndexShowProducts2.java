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
import model.ViewProductsModel;

/**
 * Servlet implementation class GoBackToIndexShowProducts2
 */
@WebServlet("/GoBackToIndexShowProducts2")
public class GoBackToIndexShowProducts2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoBackToIndexShowProducts2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ht=request.getSession();
		String adminid=(String)ht.getAttribute("adminid");
		RequestDispatcher rd=null;
		ArrayList<Product> al=new ViewProductsModel().getData();
		if(al!=null) {
			
			rd=request.getRequestDispatcher("indexshowproducts2.jsp");
			request.setAttribute("arraylist", al);		
			String ii=request.getRemoteAddr();
			ArrayList<Cart> calculated_values=new ViewProductsModel().calculateValues(ii);			
			request.setAttribute("calculated_values", calculated_values);
			
			
			
			rd.forward(request, response);
		}
	}

}
