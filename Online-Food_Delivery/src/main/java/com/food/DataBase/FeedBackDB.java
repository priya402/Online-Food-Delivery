package com.food.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.Entity.Feedback;

public class FeedBackDB {
	ConnectionDB db = new ConnectionDB();
	Connection conn = db.connect();
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	Feedback feed = null;
	public List<Feedback> getFeedback() {
		List<Feedback> list=new ArrayList<>();
		
		String query = "select * from feedback";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				feed=new Feedback();
				feed.setEmail(rs.getString("email"));
				feed.setName(rs.getString("name"));
				feed.setPhno(rs.getString("phno"));
				feed.setFeedback(rs.getString("feedback"));
				list.add(feed);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public int InsertFeedback(Feedback feed) {
		int s=0;
		try {
			String query = "insert into feedback values(?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,feed.getName() );
			pstmt.setString(2,feed.getEmail() );
			pstmt.setString(3, feed.getPhno());
			pstmt.setString(4, feed.getFeedback());

			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("Feedback Inserted");
//			else
//				System.out.println("Feedback Not Inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}
}

