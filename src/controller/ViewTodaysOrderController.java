package controller;

import java.io.IOException;
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
import model.ViewOrdersHistoryModel;
import model.ViewTodaysOrderModel;

/**
 * Servlet implementation class ViewTodaysOrderController
 */
@WebServlet("/ViewTodaysOrderController")
public class ViewTodaysOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTodaysOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		 Calendar c1=Calendar.getInstance();
			int date1=c1.get(Calendar.DATE);
			int month=c1.get(Calendar.MONTH);
			int year=c1.get(Calendar.YEAR);
			String dateonly=date1+"/"+month+"/"+year;
			
		ArrayList<Cart> al=new ViewTodaysOrderModel().getData(dateonly);
		if(al!=null)
		{
			rd=request.getRequestDispatcher("viewtodaysorder.jsp");
			request.setAttribute("orderlist", al);
			rd.forward(request,response);
		}
		else
		{
			rd=request.getRequestDispatcher("adminhome.jsp");
			request.setAttribute("nodatafound", "nodatafound");
			rd.include(request,response);
		}	
//		===============
//		HttpSession ht=request.getSession();
//		String adminid=(String)ht.getAttribute("adminid");
//		RequestDispatcher rd;
//		
//		ArrayList<Cart> al=new ViewOrdersHistoryModel().getData();
//		if(al!=null) {
//			rd=request.getRequestDispatcher("viewordershistory.jsp");
//			request.setAttribute("viewordershistory", al);
//			rd.forward(request, response);
//		}
//		else
//		{
//			rd=request.getRequestDispatcher("viewordershistory.jsp");
//			request.setAttribute("viewordershistory","Sorry! no data found about loan");
//			rd.include(request, response);
//		}
//		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
