package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Cart;
import connection.ConnectionClass;

public class ShowCartModel {
	
	static int variable_sumquantity=0;
	static double variable_sumprice=0.0;
	
	public ArrayList<Cart> getCartData(String client_ipaddress)
	{
		Connection c1=null;
		Cart cc=null;
		ArrayList<Cart> al=new ArrayList<Cart>();
		try
		{
			
			c1=new ConnectionClass().start();
			PreparedStatement ps=c1.prepareStatement("select id,name,price,weight,description,image,ipaddress,quantity,dateonly,sum(price) as sumprice,sum(quantity) as sumquantity, (price*sum(quantity)) as totalprice from carttable where ipaddress=? group by name");
			ps.setString(1,client_ipaddress);
			ResultSet rs=ps.executeQuery();
			System.out.println("ShowCartModel->    client_ipaddress="+client_ipaddress);
		

			PreparedStatement ps2=null;
		
			while(rs.next())
			{
				cc=new Cart();
				
				cc.setId(rs.getInt("id"));
				cc.setName(rs.getString("name"));
				cc.setPrice(rs.getDouble("price"));
				cc.setWeight(rs.getDouble("weight"));
				cc.setDescription(rs.getString("description"));
				cc.setImage(rs.getString("image"));
				cc.setIpaddress(rs.getString("ipaddress"));
				cc.setQuantity(rs.getInt("quantity"));
				cc.setDateonly(rs.getString("dateonly"));
				cc.setSumquantity(rs.getInt("sumquantity"));
				cc.setSumprice(rs.getDouble("sumprice"));
//				cc.setStatus(rs.getInt("status"));				
				cc.setTotalprice(rs.getDouble("totalprice"));
				
//				-------------added  columns in carttable----------------
//				ps2=c1.prepareStatement("update carttable set sumquantity=?,sumprice=? where ipaddress=?");
//				ps2.setInt(1,variable_sumquantity);
//				ps2.setDouble(2, variable_sumprice);
//				ps2.setString(3,rs.getString("ipaddress"));
//				int x=ps2.executeUpdate();
//				if(x!=0)
//					System.out.println("SHowCartModel->   sumuantity,sumprice updated in carttable ");
				al.add(cc);
				
			}
			
		}
		catch(Exception e)
		{e.printStackTrace();}
		return al;

	}
	
	
	public ArrayList<Cart> getCartDataOfSumQuantityAndSumPrice(String ipaddress)
	{
		Connection c1=null;
		Cart cc=null;
		ArrayList<Cart> al=new ArrayList<Cart>();
		try
		{
			
			c1=new ConnectionClass().start();
			PreparedStatement ps=c1.prepareStatement("select id,name,price,weight,description,image,ipaddress,quantity,dateonly,sum(price) as sumprice,sum(quantity) as sumquantity, (price*sum(quantity)) as totalprice from carttable where ipaddress=? group by name");
			ps.setString(1,ipaddress);
			ResultSet rs=ps.executeQuery();
			System.out.println("ShowCartModel->   getCartDataOfSumQuantityAndSumPrice(ipaddress)      ipaddress="+ipaddress);
		

			PreparedStatement ps2=null;
		
			while(rs.next())
			{
				cc=new Cart();
				
				cc.setId(rs.getInt("id"));
				cc.setName(rs.getString("name"));
				cc.setPrice(rs.getDouble("price"));
				cc.setWeight(rs.getDouble("weight"));
				cc.setDescription(rs.getString("description"));
				cc.setImage(rs.getString("image"));
				cc.setIpaddress(rs.getString("ipaddress"));
				cc.setQuantity(rs.getInt("quantity"));
				cc.setDateonly(rs.getString("dateonly"));
				cc.setSumquantity(rs.getInt("sumquantity"));
				cc.setSumprice(rs.getDouble("sumprice"));
//				cc.setStatus(rs.getInt("status"));				
				cc.setTotalprice(rs.getDouble("totalprice"));		
				al.add(cc);
			}
			
		}
		catch(Exception e)
		{e.printStackTrace();}
		return al;

	}
	
}
