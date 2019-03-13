package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Cart;
import beans.Customer;
import connection.ConnectionClass;

public class ViewCartModel {
	public ArrayList<Cart> retriveData(String client_ipaddress)
	{
		Connection c1=null;
		ArrayList<Cart> al=new ArrayList<Cart>();
		try
		{
			
			c1=new ConnectionClass().start();
			PreparedStatement ps=c1.prepareStatement("select * from carttable where ipaddress=?");
			ps.setString(1,client_ipaddress);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Cart l1=new Cart();
				l1.setId(rs.getInt("id"));
				l1.setName(rs.getString("name"));
				l1.setPrice(rs.getDouble("address"));
				l1.setWeight(rs.getDouble("mobilenumber"));
				l1.setDescription(rs.getString("description"));
				l1.setImage(rs.getString("image"));
				l1.setIpaddress(rs.getString("ipaddress"));
				l1.setQuantity(rs.getInt("quantity"));
				l1.setDateonly(rs.getString("dateonly"));
			
				al.add(l1);
			}
			
		}
		catch(Exception e)
		{e.printStackTrace();}
		return al;

	}
}
