package productservice.productserviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBConnect.DBConnection;
import productservice.ProductService;

public class ProductServiceImpl implements ProductService{

	@Override
	public Product getProduct(int num) {

		Product product = new Product();
		String selString = "select * "
				+ "from product join category on product.categoryid = category.categoryid "
				+ "where productid = " +num;
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
			ResultSet rs = stmt.executeQuery(selString);	
			
			if(rs.next())
			{
				product.setProductid(rs.getInt("product.productid"));
				product.setName(rs.getString("product.name"));
				product.setDescription(rs.getString("product.description"));
				product.setBasePrice(rs.getString("product.basePrice"));
				product.setCategoryid(rs.getString("product.categoryid"));
				product.setCategorydescription(rs.getString("category.description"));
				product.setAuthor(rs.getString("product.author"));
				product.setPublish(rs.getString("product.publish"));
				product.setPages(rs.getString("product.pages"));
				product.setImagePath(rs.getString("product.images"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBConnection.closeConnection(conn);
			return product;
		}
	}
}
