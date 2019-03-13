package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Cart;
import connection.ConnectionClass;

public class OrderModel {
	public int operation(String customeremail,int id_from_carttable,String hidden_field_ipaddress)
	{
		int x=0;
		int y=0;
		Connection c1=null;
		int z=0;
		Cart cc=null;
		try
		{
			int status=0;
			c1=new ConnectionClass().start();
			
			PreparedStatement ps=c1.prepareStatement("select id,name,price,weight,description,image,ipaddress,quantity,dateonly,sum(price) as sumprice,sum(quantity) as sumquantity, (price*sum(quantity)) as totalprice from carttable where ipaddress=? group by name");
			ps.setString(1,hidden_field_ipaddress);
			ResultSet rs=ps.executeQuery();
			System.out.println("ShowCartModel->   getCartDataOfSumQuantityAndSumPrice(ipaddress)      hidden_field_ipaddress="+hidden_field_ipaddress);
		

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
				
				PreparedStatement ps1=c1.prepareStatement("insert into ordertable(id,name,price,weight,description,image,ipaddress,dateonly,sumquantity,sumprice,status,customeremail) values(?,?,?,?,?,?,?,?,?,?,?,?)");
				ps1.setInt(1,rs.getInt("id"));
				ps1.setString(2, rs.getString("name"));
				ps1.setDouble(3, rs.getDouble("price"));
				ps1.setDouble(4, rs.getDouble("weight"));
				ps1.setString(5, rs.getString("description"));
				ps1.setString(6, rs.getString("image"));
				ps1.setString(7,hidden_field_ipaddress);			
				ps1.setString(8,rs.getString("dateonly"));
				ps1.setInt(9,rs.getInt("sumquantity"));
				ps1.setDouble(10,rs.getDouble("sumprice"));
				ps1.setInt(11, 1);
				ps1.setString(12, customeremail);
				
				PreparedStatement ps2=c1.prepareStatement("delete from carttable where ipaddress=? and id=?");
				ps2.setString(1, hidden_field_ipaddress);
				ps2.setInt(2, id_from_carttable);
				c1.setAutoCommit(false);
				
				x=ps1.executeUpdate();
				y=ps2.executeUpdate();
				
				c1.commit();
//				al.add(cc);
			}
			
			
//			for(Cart cart:al)
//			{
				//Product p=new Product();
				
//			PreparedStatement ps1=c1.prepareStatement("insert into ordertable(id,name,price,weight,description,image,ipaddress,dateonly,sumquantity,sumprice,status,customeremail) values(?,?,?,?,?,?,?,?,?,?,?,?)");
//				ps1.setInt(1,cart.getId());
//				ps1.setString(2, cart.getName());
//				ps1.setDouble(3, cart.getPrice());
//				ps1.setDouble(4, cart.getWeight());
//				ps1.setString(5, cart.getDescription());
//				ps1.setString(6, cart.getImage());
//				ps1.setString(7,hidden_field_ipaddress);			
//				ps1.setString(8,cart.getDateonly());
//				ps1.setInt(9,cart.getSumquantity());
//				ps1.setDouble(10,cart.getTotalprice());
//				ps1.setInt(11, 1);
//				ps1.setString(12, customeremail);
			
//				PreparedStatement ps2=c1.prepareStatement("delete from carttable where ipaddress=? and id=?");
//				ps2.setString(1, hidden_field_ipaddress);
//				ps2.setInt(2, id_from_carttable);
//				c1.setAutoCommit(false);
//				
//				x=ps1.executeUpdate();
//				y=ps2.executeUpdate();
//				
//				c1.commit();
				
				if(x!=0 && y!=0)
				{
					z=1;
//					sendMail();
				}
				
				
//			}			
		}
		catch(Exception e)
		{ e.printStackTrace();}
		return z;
	}

}
