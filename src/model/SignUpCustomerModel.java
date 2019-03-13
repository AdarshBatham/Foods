package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Customer;
import connection.ConnectionClass;

public class SignUpCustomerModel {
	public int insertData(Customer cc)
	{
		int x=0;
		Connection c1=null;
		try
		{
			
			c1=new ConnectionClass().start();
			PreparedStatement ps=c1.prepareStatement("insert into newcustomertable(name,address,mobilenumber,password) values (?,?,?,?)");
			ps.setString(1,cc.getName() );
			ps.setString(2,cc.getAddress() );
			ps.setString(3,cc.getMobilenumber() );
			ps.setString(4,cc.getPassword() );
			ps.executeUpdate();
			ps.close();
			c1.close();
			x=1;
		}
		catch(Exception e){e.printStackTrace();}
		return x;
	}

	public int check(String email, String password) {
		
			int x=0;
			Connection c1=null;
			try
			{
				
				c1=new ConnectionClass().start();
				PreparedStatement ps=c1.prepareStatement("select * from customertable where email=? and password=?");
				ps.setString(1,email);
				ps.setString(2,password);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next())
					x=1;
					
				ps.close();
				c1.close();
				x=1;
			}
			catch(Exception e){e.printStackTrace();}
			return x;
		
	}	
	
}
