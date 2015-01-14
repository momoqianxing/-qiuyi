package productservice.productserviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBConnect.DBConnection;
import productservice.ProductListService;

public class ProductListServiceImpl  implements ProductListService{

	public List getProductList()
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
			ResultSet rs = stmt.executeQuery("select * from product");
			
			while(rs.next())
			{
				ListProduct pro = new ListProduct();
				pro.setName(rs.getString("name"));
				pro.setBasePrice(rs.getString("basePrice"));
				list.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBConnection.closeConnection(conn);
			return list;
		}
	}
}
