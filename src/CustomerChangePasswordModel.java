import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.ConnectionClass;

public class CustomerChangePasswordModel {
	int changePassword(String emailid,String confirmpassword)
	{
		
		int x=0;
		Connection c1=null;
		PreparedStatement ps=null;
		try
		{
						
			c1=new ConnectionClass().start();
			
					ps=c1.prepareStatement("update customertable set password=? where emailid=?");
					ps.setString(1,confirmpassword);
					ps.setString(2,emailid);
					
				
			x=ps.executeUpdate();
//			if(x!=0)
//			{
//				sendMailPasswordChanged(sb.getAdminsession(), sb.getNewpassword());
//			}
		}
		catch(Exception e)
		{e.printStackTrace();}
		
		return x;
	}
}
