package model;	
	import java.sql.Connection;
	import java.sql.PreparedStatement;

	import connection.ConnectionClass;

	public class CustomerChangePasswordModel {
		public int changePassword(String email,String confirmpassword)
		{
			
			int x=0;
			Connection c1=null;
			PreparedStatement ps=null;
			try
			{
							
				c1=new ConnectionClass().start();
				
						ps=c1.prepareStatement("update customertable set password=? where email=?");
						ps.setString(1,confirmpassword);
						ps.setString(2,email);
						
					
				x=ps.executeUpdate();
//				if(x!=0)
//				{
//					sendMailPasswordChanged(sb.getAdminsession(), sb.getNewpassword());
//				}
			}
			catch(Exception e)
			{e.printStackTrace();}
			
			return x;
		}
	}

