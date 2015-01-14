package orderservice.orderserviceimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;








import orderservice.orderDetailserver;

import com.mysql.jdbc.Connection;

import DBConnect.DBConnection;



public class orderDetailserverimpl implements orderDetailserver{
	
	public List getorderDetail()
	{
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs = null;
		List orderDetailList = new ArrayList();
		
		try{
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = (Connection) DBConnection.getConnection();
			if(conn == null)
			{
				return null;
			}
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select product.name,product.basePrice,orderline.amount from orderline,product "
					+ "where product.productid=orderline.productid");
			
			while(rs.next())
			{
				orderDetail orderDetail =new orderDetail();
				orderDetail.setProname(rs.getString("product.name"));
				orderDetail.setPrice(rs.getString("product¡£basePrice"));
				orderDetail.setPrice(rs.getString("product¡£amount"));
				orderDetailList.add(orderDetail);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("error when querying students ",e);
		}finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return orderDetailList;
	}
	

}
