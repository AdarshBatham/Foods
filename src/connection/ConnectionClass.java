package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	public Connection start()
	{
		Connection c1=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			
		}
		catch(Exception e)
		{e.printStackTrace();}
		return c1;
	}
}
