package userservice.userserviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import DBConnect.DBConnection;
import productservice.ProductListService;
import productservice.productserviceimpl.ListProduct;
import userservice.UserModifyService;

public class UserModifyServiceImpl implements UserModifyService {
	public List getUserModifyList()
	{
		List list = new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = DBConnection.getConnection();
		if(conn == null)
		{
			System.out.println("1");
			return null;
		}

		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users join contactinfo on users.userid = contactinfo.userid where users.userid = 'zhanglulu'");

			while(rs.next())
			{
				ListUserModify user = new ListUserModify();
				System.out.println(rs.getString("users.userid"));
				user.setUserid( rs.getString("users.userid") );		
				user.setPassword( rs.getString("users.password") );
				user.setCity( rs.getString("contactinfo.city") );
				user.setProvince( rs.getString("contactinfo.province") );
				user.setCountry( rs.getString("contactinfo.country") );
				user.setStreet1( rs.getString("contactinfo.street1") );
				user.setStreet2( rs.getString("contactinfo.Street2") );
				user.setZip( rs.getString("contactinfo.zip") );
				user.setHomephone( rs.getString("contactinfo.homephone") );
				user.setCellphone( rs.getString("contactinfo.cellphone") );
				user.setOfficephone( rs.getString("contactinfo.officephone") );
				user.setEmail( rs.getString("contactinfo.email") );
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		finally
		{
			DBConnection.closeConnection(conn);
			return list;
		}
	}
}
