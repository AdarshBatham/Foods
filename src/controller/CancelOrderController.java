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
import model.CancelOrderModel;
import model.OrderModel;
import model.ShowCartModel;

/**
 * Servlet implementation class CancelOrderController
 */
@WebServlet("/CancelOrderController")
public class CancelOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderController() {
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
		String ipaddress1=(String)ht.getAttribute("client_ipaddress");		
		String customeremail=(String)ht.getAttribute("customer_email(session)");
		
		//--------------hidden field values from "viewpendingproductstocustomer.jsp"----------------
		int id_from_carttable=Integer.parseInt(request.getParameter("id"));
		String customer_ipaddress=request.getParameter("ipaddress");
		
				int x=new CancelOrderModel().cancelOrderNow(customer_ipaddress,id_from_carttable);
			
				if(x==1)
				{
					
					String client_ipaddress=(String)ht.getAttribute("client_ipaddress");
					ArrayList<Cart> al=(ArrayList<Cart>)new ShowCartModel().getCartData(client_ipaddress);
					RequestDispatcher rd=request.getRequestDispatcher("viewpendingproductstocustomer.jsp");
					request.setAttribute("unorderedproducts", al);
					rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("customerhome.jsp");
					request.setAttribute("unorderedproducts", "Order Not placed");
					rd.forward(request, response);
				}
			
	}

}
