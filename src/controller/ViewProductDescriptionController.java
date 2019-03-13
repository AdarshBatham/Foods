package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import model.ViewProductsModel;

/**
 * Servlet implementation class ViewProductDescriptionController
 */
@WebServlet("/ViewProductDescriptionController")
public class ViewProductDescriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProductDescriptionController() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		
		RequestDispatcher rd=null;
		ArrayList<Product> al=new ViewProductsModel().showDescription(id);
		System.out.println("id="+id);
		
		if(al.isEmpty())
		{
			System.out.println("List is empty");
			rd=request.getRequestDispatcher("show_description.jsp");
			request.setAttribute("show_description", "nothing to show");
//			ArrayList<Product> a1=new ViewProductsModel().getData();
		}
		else
		{
			rd=request.getRequestDispatcher("show_description.jsp");
			request.setAttribute("show_description", al);
			rd.forward(request,response);
		}
	}

}
