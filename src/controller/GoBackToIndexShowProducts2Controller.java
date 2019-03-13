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
 * Servlet implementation class GoBackToIndexShowProducts2Controller
 */
@WebServlet("/GoBackToIndexShowProducts2Controller")
public class GoBackToIndexShowProducts2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoBackToIndexShowProducts2Controller() {
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
		HttpSession ht=request.getSession();
		String adminid=(String)ht.getAttribute("adminid");
		RequestDispatcher rd;
		
		ArrayList<Product> al=new ViewProductsModel().getData();
		if(al!=null) {
			rd=request.getRequestDispatcher("indexshowproducts2.jsp");
			request.setAttribute("arraylist", al);
			rd.forward(request, response);
		}
		else
		{
			rd=request.getRequestDispatcher("indexshowproducts2.jsp");
			request.setAttribute("nodatafound","Sorry! no data found about loan");
			rd.include(request, response);
		}
	}

}
