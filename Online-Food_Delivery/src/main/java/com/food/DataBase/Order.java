package com.food.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.food.Entity.Orders;
import com.food.Entity.Restorunt;

public class Order {
	ConnectionDB db = new ConnectionDB();
	Connection conn = db.connect();
	ResultSet rs;
	Statement stmt;
	Restorunt resto;
	PreparedStatement pstmt;
	Orders ord;

	public int Insert(List<Orders> orde) {
		Set<Orders> order = new HashSet<>(orde);
		int s = 0;
		try {
			String query = "insert into orders(cid,rid,date,mid) values(?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			for (Orders orders : order) {
				// pstmt.setInt(1, orders.getOid());
				pstmt.setString(1, orders.getCid());
				pstmt.setInt(2, orders.getRid());
				pstmt.setDate(3, orders.getDate());
				pstmt.setInt(4, orders.getMid());

				pstmt.addBatch();

			}

			int k[] = pstmt.executeBatch();
			s = (k.length > 0 && k[0] > 0) ? 1 : 0;
//			if (s > 0)
//				System.out.println("Order Placed");
//			else
//				System.out.println("Something Went Wrog !");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}

	public List<Orders> getOrder() {
		List<Orders> order = new ArrayList<>();

		try {
			String query = "Select * from orders  ;";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);
//			if (rs == null)
//				System.out.println("record Not Found");

			while (rs.next()) {
				ord = new Orders();
				ord.setCid(rs.getString("cid"));
				ord.setMid(rs.getInt("mid"));
				ord.setOid(rs.getInt("oid"));
				ord.setRid(rs.getInt("rid"));
				ord.setDate(rs.getDate("date"));
				ord.setStatus(rs.getString("status"));
				ord.setDid( rs.getInt("boyid"));
				//System.out.println(ord.getDid()+"doremon2");
				order.add(ord);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return order;
	}
	

	public int OrderUpdates(String sk,int i)
	{
		int s = 0;
		try {
			String query = "update orders set status=? where mid=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,sk );
			pstmt.setInt(2, i);
			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("Status Updated");
//			else
//				System.out.println("Status Not Updated");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
		
	}
	public int OrderDelivery(int i,int boy)
	{
		int s = 0;
		try {
			String query = "update orders set boyid=? where mid=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,boy );
			pstmt.setInt(2, i);
			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("Status Updated");
//			else
//				System.out.println("Status Not Updated");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
		
	}
	
	
	}


