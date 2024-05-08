package com.food.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.food.Entity.Admin;

public class AdminDao {
	ConnectionDB db = new ConnectionDB();
	Connection conn = db.connect();
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	Admin admin = null;
	public Admin getInfo() {
		
		String query = "select * from admin";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				admin = new Admin();
				admin.setEmail(rs.getString("email"));
				admin.setName(rs.getString("name"));
				admin.setPass(rs.getString("pass"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return admin;
	}

	public int InsertAdmin(Admin admin) {
		int s=0;
		try {
			String query = "insert into admin(name,email,pass) values(?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, admin.getName());
			pstmt.setString(2, admin.getEmail());
			pstmt.setString(3, admin.getPass());

			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("Admin Inserted");
//			else
//				System.out.println("Admin Not Inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}
}
