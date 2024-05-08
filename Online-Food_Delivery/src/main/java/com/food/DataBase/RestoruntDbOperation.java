package com.food.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.Dao.RestorunDao;
import com.food.Entity.Restorunt;

public class RestoruntDbOperation implements RestorunDao {
	ConnectionDB db = new ConnectionDB();
	Connection conn = db.connect();
	ResultSet rs;
	Statement stmt;
	Restorunt resto;
	PreparedStatement pstmt;

	@Override
	public List<Restorunt> getAll() {
		List<Restorunt> list = new ArrayList<>();

		try {
			String query = "Select * from restorunt_info";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				resto = new Restorunt();
				resto.setRname(rs.getString("rname"));
				resto.setAddress(rs.getString("address"));
				resto.setRno(rs.getString("rno"));
				resto.setRid(rs.getInt("rid"));
				resto.setPass(rs.getString("pass"));
				resto.setEmail(rs.getString("email"));

				list.add(resto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Restorunt getRestorunt(Restorunt r) {
		try {
			String query = "Select * from restorunt_info where rno=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, r.getRid());
			rs = pstmt.executeQuery();
			if (rs == null)
				System.out.println("record Not Found");

			if (rs.next()) {
				resto = new Restorunt();
				resto.setRname(rs.getString("rname"));
				resto.setAddress(rs.getString("address"));
				resto.setRno(rs.getString("rno"));
				resto.setRid(rs.getInt("rid"));
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resto;
	}

	@Override
	public int Insert(Restorunt r) {
		int s=0;
		try {
			String query = "insert into restorunt_info(rname,address,rno,email,pass) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getRname());
			pstmt.setString(2, r.getAddress());
			pstmt.setString(3, r.getRno());
			pstmt.setString(4, r.getEmail());
			pstmt.setString(5, r.getPass());
			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("Account Created Success");
//			else
//				System.out.println("Something Went Wrog !");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}
	
	public int Update(Restorunt u)
	{
		int s = 0;
		try {
			String query = "update restorunt_info set pass=? where email=? and rno=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getRno());
			pstmt.setString(1, u.getPass());
			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("password Updated");
//			else
//				System.out.println("password Not Updated");

		} catch (Exception e) {
			e.printStackTrace();		}
		
		return s;
		
	}
	public int Delete(int u)
	{
		int s = 0;
		try {
			String query = "delete from restorunt_info where rid=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, u);
			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("Data Delete");
//			else
//				System.out.println("Data Not Delete");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
		
	}
	public int UpdateInfo(Restorunt u)
	{
		int s = 0;
		try {
			String query = "update restorunt_info set email=?,rno=?,pass=?,address=?,rname=? where rid=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, u.getEmail());
			pstmt.setString(2, u.getRno());
			pstmt.setString(3, u.getPass());
			pstmt.setString(4, u.getAddress());
			pstmt.setString(5, u.getRname());
			pstmt.setInt(6, u.getRid());
			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("Data Updated");
//			else
//				System.out.println("data Not Updated");

		} catch (Exception e) {
			e.printStackTrace();
			}
		
		return s;
		
	}

	public Restorunt getRestorunt(int r) {
		try {
			String query = "Select * from restorunt_info where rid=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, r);
			rs = pstmt.executeQuery();
//			if (rs == null)
//				System.out.println("record Not Found");

			if (rs.next()) {
				resto = new Restorunt();
				resto.setRname(rs.getString("rname"));
				resto.setAddress(rs.getString("address"));
				resto.setRno(rs.getString("rno"));
				resto.setRid(rs.getInt("rid"));
				resto.setEmail(rs.getString("email"));
				resto.setPass(rs.getString("pass"));
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resto;
	}
	
	public int RestoCount()
	{
		int s=0;
		try
		{
			String query="select count(*) from restorunt_info";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			if(rs.next())
			{
				s=rs.getInt(1);
				//System.out.println(s+"Doremon3");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return s;
	}

}


