package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Cart;
import connection.ConnectionClass;

public class CancelOrderModel {
	public int cancelOrderNow(String client_ipaddress,int id_from_carttable)
	{
		int x=0;
		Connection c1=null;
		Cart cc=null;
		ArrayList<Cart> al=new ArrayList<Cart>();
		try
		{
			
			c1=new ConnectionClass().start();
			PreparedStatement ps=c1.prepareStatement("delete from carttable where id=? and ipaddress=?");
			ps.setInt(1,id_from_carttable);
			ps.setString(2,client_ipaddress);
			x=ps.executeUpdate();
			System.out.println("CancelOrderModel->    client_ipaddress="+client_ipaddress);		
		}
		catch(Exception e)
		{e.printStackTrace();}
		return x;
	}

}
