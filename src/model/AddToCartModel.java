package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Product;
import connection.ConnectionClass;

public class AddToCartModel {
	
	public ArrayList<Product> fetchData(int id)
	{
		ArrayList<Product> list=new ArrayList<Product>();
		Connection c1=null;
		try
		{
			c1=new ConnectionClass().start();
			PreparedStatement ps=c1.prepareStatement("select * from product where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Product p1=new Product();
				p1.setId(rs.getInt("id"));
				p1.setName(rs.getString("name"));
				p1.setPrice(rs.getDouble("price"));
				p1.setWeight(rs.getDouble("weight"));
				p1.setDescription(rs.getString("description"));
				p1.setImage(rs.getString("image"));
				list.add(p1);
				
			}
		}
		catch(Exception e)
		{ e.printStackTrace();}
		
		return list;
	}
	
	
	public int insertData(ArrayList<Product> al,String ipaddress,int quantity,String dateonly)
	{
		int x=0;
		Connection c1=null;
		try
		{
			
			c1=new ConnectionClass().start();
			
			for(Product p:al)
			{
				//Product p=new Product();
				PreparedStatement ps=c1.prepareStatement("insert into carttable(id,name,price,weight,description,image,ipaddress,quantity,dateonly,status) values(?,?,?,?,?,?,?,?,?,?)");
				
				ps.setInt(1,p.getId());
				ps.setString(2, p.getName());
				ps.setDouble(3, p.getPrice());
				ps.setDouble(4, p.getWeight());
				ps.setString(5, p.getDescription());
				ps.setString(6, p.getImage());
				ps.setString(7,ipaddress);
				ps.setInt(8, quantity);
				ps.setString(9,dateonly);
				ps.setInt(10, 0);
				x=ps.executeUpdate();
				
				
			}			
		}
		catch(Exception e)
		{ e.printStackTrace();}
		return x;
	}

}
