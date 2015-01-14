package userservice.userserviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBConnect.DBConnection;
import userservice.UserListService;

public class UserListServiceImpl implements UserListService{
	public List getUserList()
	{
		List list = new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn = DBConnection.getConnection();
		if(conn == null)
		{
			return null;
		}

		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			
			while(rs.next())
			{
				ListUser user = new ListUser();
				user.setUserid(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("error when querying students ",e);
		}
		finally
		{
			DBConnection.closeConnection(conn);
			return list;
		}
	}

}
