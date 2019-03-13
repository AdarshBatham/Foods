package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import beans.Cart;
import connection.ConnectionClass;

public class CancelOrderModelFromOrderTable {
	public int cancelOrderNow(String client_email,int id_from_ordertable)
	{
		int x=0;
		Connection c1=null;
		Cart cc=null;
		ArrayList<Cart> al=new ArrayList<Cart>();
		try
		{
			
			c1=new ConnectionClass().start();
			PreparedStatement ps=c1.prepareStatement("delete from ordertable where id=? and customeremail=?");
			ps.setInt(1,id_from_ordertable);
			ps.setString(2,client_email);
			x=ps.executeUpdate();
			System.out.println("CancelOrderModelFromOrderTable  ------>    client_email="+client_email);		
		}
		catch(Exception e)
		{e.printStackTrace();}
		return x;
	}

}
