package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.Customer_Cart;
import connection.ConnectionClass;

public class CustomerUpdateDetailsNowModel {
	int x=0;
	public int updateDetails(Customer_Cart cc)
	{
		
		Connection c1=null;
		try
		{
			
			c1=new ConnectionClass().start();
		
				PreparedStatement ps=c1.prepareStatement("update customertable set email=?,firstname=?,lastname=?,address1=?,address2=?,postalcode=?,city=?,state=?,mobilenumber=?,password=? where id=?");
				System.out.println("CustomerUpdateDetailsNowModel----->11111");
				ps.setString(1,cc.getEmail());
				ps.setString(2, cc.getFirstname());
				ps.setString(3, cc.getLastname());
				ps.setString(4, cc.getAddress1());
				ps.setString(5, cc.getAddress2());
				ps.setString(6, cc.getPostalcode());
				ps.setString(7,cc.getCity());
				ps.setString(8,cc.getState());
				ps.setString(9,cc.getMobilenumber());
				ps.setString(10,cc.getPassword());
				ps.setInt(11,cc.getCustomerid());
				x=ps.executeUpdate();
				System.out.println(x+">>"+cc.getCustomerid()+"CustomerUpdateDetailsNowModel----->22222");
		}
		catch(Exception e)
		{ e.printStackTrace();}
		return x;
	}
	
}
