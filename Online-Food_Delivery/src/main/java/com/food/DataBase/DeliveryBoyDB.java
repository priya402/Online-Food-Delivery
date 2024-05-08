package com.food.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.Dao.DeliveryBoyDao;
import com.food.Entity.DeliveryBoy;

public class DeliveryBoyDB implements DeliveryBoyDao {
	
	ConnectionDB db=new  ConnectionDB();
	Connection conn=db.connect();
	Statement stmt;
	PreparedStatement pstmt;
	DeliveryBoy boy=null;
	ResultSet rs;
	
	
	public List<DeliveryBoy> getall()
	{
		List<DeliveryBoy> list=new ArrayList<DeliveryBoy>();
		try {
			String query = "Select * from deliveryboy";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				boy=new DeliveryBoy();
				boy.setAddress(rs.getString("address"));
				boy.setEmail(rs.getString("email"));
				boy.setName(rs.getString("name"));
				boy.setPhno(rs.getString("phno"));
				boy.setPass(rs.getString("pass"));
				boy.setId(rs.getInt("did"));
				
				list.add(boy);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public DeliveryBoy getBoy(int i)
	{
		try {
			String query = "Select * from deliveryboy where did=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, i);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				boy=new DeliveryBoy();
				boy.setAddress(rs.getString("address"));
				boy.setEmail(rs.getString("email"));
				boy.setName(rs.getString("name"));
				boy.setPhno(rs.getString("phno"));
				boy.setPass(rs.getString("pass"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			}
		return boy;
		
	}
	
	public int InfoUpdate(DeliveryBoy boy)
	{
		int s=0;
		try {
			String query = "update deliveryboy set pass=?,email=?,name=?,phno=? ,address=? where did=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, boy.getPass());
			pstmt.setString(2, boy.getEmail());
			pstmt.setString(3, boy.getName());
			pstmt.setString(4, boy.getPhno());
			pstmt.setString(5, boy.getAddress());
			pstmt.setInt(6, boy.getId());

			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("Delivery Boy Information Updated");
//			else
//				System.out.println("Information Not Updated");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return  s;
	}
	
	public int InfoDelete(int i)
	{
		int s=0;
		try {
			String query = "Delete from  deliveryboy  where did=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, i);

			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("Delivery Boy Information Delete");
//			else
//				System.out.println("Information Not Delete");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return  s;
	}
	
	public int InsertInfo(DeliveryBoy boy)
	{
		int s=0;
		try {
			String query = "insert into deliveryboy(pass,email,name,phno,address) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, boy.getPass());
			pstmt.setString(2, boy.getEmail());
			pstmt.setString(3, boy.getName());
			pstmt.setString(4, boy.getPhno());
			pstmt.setString(5, boy.getAddress());

			s = pstmt.executeUpdate();
//			if (s > 0)
//				System.out.println("Delivery Boy Information Updated");
//			else
//				System.out.println("Information Not Updated");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	public int BoyCount()
	{
		int s=0;
		try
		{
			String query="select count(*) from deliveryboy";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			if(rs.next())
			{
				s=rs.getInt(1);
				//System.out.println(s+" Doremone");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			}
		
		return s;
	}
	
	
}
