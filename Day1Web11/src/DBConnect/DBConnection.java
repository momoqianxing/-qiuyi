package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;

public class DBConnection {

	public static String connString = "jdbc:mysql://localhost:3306/gwap";
	public static String username = "root";
	public static String password = "";
	
	public static Connection getConnection()
	{
		try{
		    return DriverManager.getConnection(connString,username,password);
		}
		catch (Exception e) {
			e.printStackTrace();
			try {
				throw new ServletException("error when querying students ",e);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		} 

	}
	
	public static void closeConnection(Connection conn)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
