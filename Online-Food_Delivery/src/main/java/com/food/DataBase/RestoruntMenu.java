package com.food.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.Dao.MenuDao;
import com.food.Entity.MenuItem;

public class RestoruntMenu implements MenuDao {
	ConnectionDB db = new ConnectionDB();
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	Connection conn = db.connect();
	MenuItem menu;

	@Override
	public List<MenuItem> getAllMenu() {
		List<MenuItem> list = new ArrayList<>();

		try {
			String query = "Select * from resto_menu ;";
			stmt=conn.createStatement();

			rs = stmt.executeQuery(query);
			if (rs == null)
				System.out.println("record Not Found");

			while (rs.next()) {
				menu = new MenuItem();
				menu.setId(rs.getInt("mid"));
				menu.setName(rs.getString("mname"));
				menu.setPrice(rs.getString("price"));
				menu.setType(rs.getString("type"));
				menu.setImage(rs.getString("image"));
				menu.setDescription(rs.getString("description"));
				menu.setResto_id(rs.getInt("resto_id"));
				menu.setDiscount(rs.getInt("discount"));
				list.add(menu);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public MenuItem getMenu(int mid) {
		try {
			String query = "Select * from resto_menu where  mid=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mid);

			
			rs = pstmt.executeQuery();
//			if (rs == null)
//				System.out.println("record Not Found");

			if (rs.next()) {
				menu = new MenuItem();
				menu.setId(rs.getInt("mid"));
				menu.setName(rs.getString("mname"));
				menu.setPrice(rs.getString("price"));
				menu.setType(rs.getString("type"));
				menu.setImage(rs.getString("image"));
				menu.setDescription(rs.getString("description"));
				menu.setResto_id(rs.getInt("resto_id"));
				menu.setDiscount(rs.getInt("discount"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return menu;
	}

	@Override
	public int addMenu(MenuItem menu) {
		int s=0;
		try {
			String query = "insert into resto_menu(mname,price,description,type,resto_id,image,discount) values(?,?,?,?,?,?,?) ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, menu.getName());
			pstmt.setString(2,menu.getPrice());
			pstmt.setString(3, menu.getDescription());
			pstmt.setString(4, menu.getType());
			pstmt.setInt(5, menu.getResto_id());
			pstmt.setString(6, menu.getImage());
			pstmt.setInt(7, menu.getDiscount());
			
			 s = pstmt.executeUpdate();
//			if (s >0)
//				System.out.println("Menu Inserted");
//			else 
//				System.out.println("Menu Not Inserted");

	

		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}

	@Override
	public int updateMenu(MenuItem menu) {
		int s=0;
		try {
			String query = "update resto_menu set mname=?,price=?,description=?,type=?,resto_id=?,discount=? where mid=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, menu.getName());
			pstmt.setString(2,menu.getPrice());
			pstmt.setString(3, menu.getDescription());
			pstmt.setString(4, menu.getType());
			pstmt.setInt(5, menu.getResto_id());
			
			pstmt.setInt(6, menu.getDiscount());
			pstmt.setInt(7, menu.getId());
			
			 s = pstmt.executeUpdate();
//			if (s >0)
//				System.out.println("Menu Updated");
//			else 
//				System.out.println("Menu Not Update");

	

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	
	public int deleteMenu(MenuItem menu) {
		int s=0;
			try {
				String query = "delete from resto_menu where resto_id=? and mid=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, menu.getResto_id());
				pstmt.setInt(2, menu.getId());

				
				 s = pstmt.executeUpdate();
//				if (s >0)
//					System.out.println("record Delete");
//				else 
//					System.out.println("some thing hapen");

		} catch (Exception e) {
			e.printStackTrace();
		}
// TODO Auto-generated method stub
		return s;
	}

}
