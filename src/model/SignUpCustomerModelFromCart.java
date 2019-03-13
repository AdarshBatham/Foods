package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import beans.Customer;
import beans.Customer_Cart;
import beans.Product;
import connection.ConnectionClass;

public class SignUpCustomerModelFromCart {
	public int insertData(Customer_Cart cc)
	{
		int x=0;
		Connection c1=null;
		try
		{		
			c1=new ConnectionClass().start();
		
				//Product p=new Product();
				PreparedStatement ps=c1.prepareStatement("insert into customertable(email,firstname,lastname,address1,address2,postalcode,city,state,mobilenumber,password) values(?,?,?,?,?,?,?,?,?,?)");
				
				ps.setString(1, cc.getEmail());
				ps.setString(2, cc.getFirstname());
				ps.setString(3, cc.getLastname());
				ps.setString(4, cc.getAddress1());
				ps.setString(5, cc.getAddress2());
				ps.setString(6, cc.getPostalcode());
				ps.setString(7, cc.getCity());
				ps.setString(8, cc.getState());
				ps.setString(9, cc.getMobilenumber());
				ps.setString(10, cc.getPassword());
				
				x=ps.executeUpdate();
				
				
						
		}
		catch(Exception e)
		{ e.printStackTrace();}
		return x;
	}


}
