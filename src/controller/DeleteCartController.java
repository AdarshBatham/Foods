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
import model.DeleteModel;
import model.ShowCartModel;
import model.ViewProductsModel;

/**
 * Servlet implementation class DeleteCartController
 */
@WebServlet("/DeleteCartController")
public class DeleteCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartController() {
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
		try
		{
			HttpSession ht=request.getSession();
			String client_ipaddress=(String)ht.getAttribute("client_ipaddress");
			RequestDispatcher rd;
			String name=request.getParameter("hidden");
			int y=new DeleteModel().deleteData(name);
			if(y==1)
			{
				rd=request.getRequestDispatcher("showcart.jsp");
				ArrayList<Cart> al1=new ShowCartModel().getCartData(client_ipaddress);
				request.setAttribute("cartlist", al1);
				rd.forward(request, response);
			}
			
		}
		catch(Exception e)
		{e.printStackTrace();}
	}

}
