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
import model.CancelOrderModelFromOrderTable;
import model.PlacedOrdersModel;
import model.ShowCartModel;

/**
 * Servlet implementation class CancelOrderControllerFromOrderTable
 */
@WebServlet("/CancelOrderControllerFromOrderTable")
public class CancelOrderControllerFromOrderTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderControllerFromOrderTable() {
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
		int id_from_ordertable=Integer.parseInt(request.getParameter("id"));
		String customer_email=request.getParameter("customeremail");
		
				int x=new CancelOrderModelFromOrderTable().cancelOrderNow(customer_email,id_from_ordertable);
			
				if(x==1)
				{
					ArrayList<Cart> al=(ArrayList<Cart>)new PlacedOrdersModel().getData(customer_email);
					RequestDispatcher rd=request.getRequestDispatcher("vieworderedproductstocustomer.jsp");
					request.setAttribute("orderedproducts", al);
					rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("vieworderedproductstocustomer.jsp");
					request.setAttribute("orderedproducts", "Order Not placed");
					rd.forward(request, response);
				}
	}

}
