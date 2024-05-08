package com.food.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.food.Dao.UserDao;
import com.food.Entity.User;

public class UserDbOperation implements UserDao {

	private ConnectionDB db = new ConnectionDB();
	private User u;
	private Connection con = db.connect();
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public List<User> getAll() {
		List<User> ulist = new ArrayList<>();
		try {
			String query = "Select * from user_info";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				u = new User();
				u.setUname(rs.getString("uname"));
				u.setEmail(rs.getString("email"));
				u.setAddress(rs.getString("address"));
				u.setMno(rs.getString("no"));
				u.setPass(rs.getString("pass"));
				u.setId(rs.getInt("uid"));

				ulist.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ulist;
	}

	@Override
	public User getUser(User user) {
		try {
			String query = "Select * from user_info where email=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(0, user.getEmail());
			rs = pstmt.executeQuery();
			if (rs == null)
				System.out.println("record Not Found");

			if (rs.next()) {
				u=new User();
				u.setUname(rs.getString("uname"));
				u.setEmail(rs.getString("email"));
				u.setAddress(rs.getString("address"));
				u.setMno(rs.getString("no"));
				u.setPass(rs.getString("pass"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	@Override
	public int Insert(User user) {
		int s = 0;
		try {
			String query = "insert into user_info(uname,email,no,address,pass) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getMno());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getPass());
			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("Data Inserted");
//			else
//				System.out.println("Data Not Inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}
	
	public int Update(User u)
	{
		int s = 0;
		try {
			String query = "update user_info set pass=? where email=? and no=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getMno());
			pstmt.setString(1, u.getPass());
			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("password Updated");
//			else
//				System.out.println("password Not Updated");

		} catch (Exception e) {
			e.printStackTrace();
			}
		
		return s;
		
	}
	public int UpdateUser(User u)
	{
		int s = 0;
		try {
			String query = "update user_info set uname=?,email=?,no=?,address=?,pass=? where uid=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, u.getUname());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getMno());
			pstmt.setString(4, u.getAddress());
			pstmt.setString(5, u.getPass());
			pstmt.setInt(6, u.getId());
			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("Data Updated");
//			else
//				System.out.println("Data Not Updated");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
		
	}
	public int Delete(int u)
	{
		int s = 0;
		try {
			String query = "delete from user_info where uid=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, u);
			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("password Updated");
//			else
//				System.out.println("password Not Updated");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
		
	}

	public User getUser(int us) {
		try {
			String query = "Select * from user_info where uid=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, us);
			rs = pstmt.executeQuery();
			if (rs == null)
				System.out.println("record Not Found");

			if (rs.next()) {
				u=new User();
				u.setUname(rs.getString("uname"));
				u.setEmail(rs.getString("email"));
				u.setAddress(rs.getString("address"));
				u.setMno(rs.getString("no"));
				u.setPass(rs.getString("pass"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}
	
	
	public int UserCount()
	{
		int s=0;
		try
		{
			String query="select count(*) from user_info";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			if(rs.next())
			{
				s=rs.getInt(1);
				//System.out.println(s+"Doremon4");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return s;
	}

}
