package orderservice.orderserviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





import orderservice.orderUserserver;
import DBConnect.DBConnection;



public class orderUserserverimpl implements orderUserserver{
	public List getUserList()
	{
		List userlist = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn = (Connection) DBConnection.getConnection();
		if(conn == null)
		{
			return null;
		}

		Statement stmt;
		ResultSet rs;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select orders.userid ,city,zip,email,homephone,cellphone,officephone,payway.paystyle "
					+ "from contactinfo,payway,orders "
					+ "where payway.paywayid =orders.paywayid and orders.userid =contactinfo");
			
			while(rs.next())
			{
				userInfo user = new userInfo();
				user.setUserid(rs.getString("orders.userid"));
				user.setCity(rs.getString("city"));
				user.setZip(rs.getString("zip"));
				user.setHomephone(rs.getString("homephone"));
				user.setOfficephone(rs.getString("officephone"));
				user.setCellphone(rs.getString("cellphone"));
				user.setEmail(rs.getString("email"));
				user.setPaystyle(rs.getString("payway.paystyle"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBConnection.closeConnection(conn);
			return userlist;
		}
	
	}

}
