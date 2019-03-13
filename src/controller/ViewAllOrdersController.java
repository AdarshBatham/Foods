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
import model.ViewOrdersHistoryModel;

/**
 * Servlet implementation class ViewAllOrdersController
 */
@WebServlet("/ViewAllOrdersController")
public class ViewAllOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllOrdersController() {
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
		String customeremail=(String)ht.getAttribute("customer_email(session)");
		RequestDispatcher rd;
		
		ArrayList<Cart> al=new ViewOrdersHistoryModel().getAllData(customeremail);
		if(al!=null) {
			rd=request.getRequestDispatcher("viewallorders.jsp");
			request.setAttribute("viewordershistory", al);
			rd.forward(request, response);
		}
		else
		{
			rd=request.getRequestDispatcher("viewordershistory.jsp");
			request.setAttribute("viewordershistory","Sorry! no data found about loan");
			rd.include(request, response);
		}
	}

}
