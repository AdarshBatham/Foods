package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cart;
import beans.Product;
import model.AddToCartModel;
import model.ViewProductsModel;

/**
 * Servlet implementation class AddToCartController
 */
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartController() {
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
		PrintWriter out=response.getWriter();
		HttpSession ht=request.getSession();
		
//		InetAddress addr=InetAddress.getLocalHost();
//		String client_ipaddress=addr.getHostAddress();
		String client_ipaddress=request.getRemoteAddr();
		ht.setAttribute("client_ipaddress",client_ipaddress);
		int id=Integer.parseInt(request.getParameter("hidden1"));
		
		
	
//		String stringquantity=request.getParameter("quantity");
		int quantity=Integer.parseInt(request.getParameter("productquantity"));
		out.println(quantity);
		
		Calendar c1=Calendar.getInstance();
		int date1=c1.get(Calendar.DATE);
		int month=c1.get(Calendar.MONTH);
		int year=c1.get(Calendar.YEAR);
		String dateonly=date1+"/"+month+"/"+year;
		
		AddToCartModel acm=new AddToCartModel();
		
		ArrayList<Product> al=(ArrayList<Product>)acm.fetchData(id);
		
		if(quantity!=0)
		{
				int x=acm.insertData(al,client_ipaddress,quantity,dateonly);
				if(x==1)
				{
					RequestDispatcher rd=request.getRequestDispatcher("indexshowproducts2.jsp");
					String ii=request.getRemoteAddr();
					ArrayList<Cart> calculated_values=new ViewProductsModel().calculateValues(ii);			
					request.setAttribute("calculated_values", calculated_values);
					
					request.setAttribute("m2","your product has been added to cart");
					ArrayList<Product> al1=new ViewProductsModel().getData();
					request.setAttribute("arraylist", al1);
					rd.forward(request,response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("indexshowproducts2.jsp");
					
					String ii=request.getRemoteAddr();
					ArrayList<Cart> calculated_values=new ViewProductsModel().calculateValues(ii);			
					request.setAttribute("calculated_values", calculated_values);
					
					request.setAttribute("m2","not able add your product to cart");
					ArrayList<Product> al1=new ViewProductsModel().getData();
					request.setAttribute("arraylist", al1);
					rd.include(request,response);
				}
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("indexshowproducts2.jsp");
			request.setAttribute("invalidquantity","not able add your product,quantity must be greater than 0");
			
			String ii=request.getRemoteAddr();
			ArrayList<Cart> calculated_values=new ViewProductsModel().calculateValues(ii);			
			request.setAttribute("calculated_values", calculated_values);
			
			ArrayList<Product> al1=new ViewProductsModel().getData();
			request.setAttribute("arraylist", al1);
			rd.include(request,response);
			
		}
	}

}
