package com.food.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	
	Connection conn=null;
	public Connection connect()
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/zomato","postgres","postgres");
//			if(conn!=null)
//				System.out.println("Connected Success");
			
		}catch(Exception e)
		{

		e.printStackTrace();
		}
		
		return conn;
	}

}
