package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Customer_Cart;
import beans.Product;
import connection.ConnectionClass;

public class CustomerUpdateProfileModel {
	Connection c1=null;
	Customer_Cart cc=null;
	public Customer_Cart getDetails(String email)
	{
		try
		{
			
			c1=new ConnectionClass().start();
			PreparedStatement ps=c1.prepareStatement("select * from customertable where email=?");
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				cc=new Customer_Cart();
				cc.setId(rs.getInt("id"));
				cc.setEmail(rs.getString("email"));
				cc.setFirstname(rs.getString("firstname"));
				cc.setLastname(rs.getString("lastname"));
				cc.setAddress1(rs.getString("address1"));
				cc.setAddress2(rs.getString("address2"));
				cc.setPostalcode(rs.getString("postalcode"));
				cc.setCity(rs.getString("city"));
				cc.setState(rs.getString("state"));
				cc.setMobilenumber(rs.getString("mobilenumber"));
				cc.setPassword(rs.getString("password"));	
			}
			
		}
		catch(Exception e)
		{e.printStackTrace();}
		
		return cc;
	}
}
