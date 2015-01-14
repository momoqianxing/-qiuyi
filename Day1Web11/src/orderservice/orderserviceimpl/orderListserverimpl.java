package orderservice.orderserviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;







import orderservice.orderListserver;
import DBConnect.DBConnection;


public class orderListserverimpl implements orderListserver{
	public List getorderList()
	{
		List orderlist = new ArrayList();
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
		rs = stmt.executeQuery("select orders.orderid,cost,orderstatus.name,payway.paystyle from orders,orderstatus,payway"
					+ " where orderstatus.paywayid = orders.paywayid and orders.statuid = orderstatus.statuid ");
			//select * from orders join orderstatus on orders.statusid = orderstatus.statusid join payway on payway.paywayid = orders.paywayid"
			while(rs.next())
			{
				orderList orderList =new orderList();
				orderList.setOrderid(rs.getString("orders.orderid"));
				orderList.setCost(rs.getString("cost"));
				orderList.setStatus(rs.getString("orderstatus.name"));
				orderList.setPayway(rs.getString("payway.paystyle"));
				
				orderlist.add(orderList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBConnection.closeConnection(conn);
			return orderlist;
		}
	
	}

}
