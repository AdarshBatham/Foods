package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cart;
import model.ViewOrdersHistoryModel;

/**
 * Servlet implementation class ViewAllOrdersToAdminController
 */
@WebServlet("/ViewAllOrdersToAdminController")
public class ViewAllOrdersToAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllOrdersToAdminController() {
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
RequestDispatcher rd;
		
		ArrayList<Cart> al=new ViewOrdersHistoryModel().getAllDataToAdmin();
		if(al!=null) {
			rd=request.getRequestDispatcher("viewallorders.jsp");
			request.setAttribute("viewordershistory", al);
			rd.forward(request, response);
		}
		else
		{
			rd=request.getRequestDispatcher("viewallorders.jsp");
			request.setAttribute("viewordershistory","Sorry! no data found");
			rd.include(request, response);
		}
	}

}
