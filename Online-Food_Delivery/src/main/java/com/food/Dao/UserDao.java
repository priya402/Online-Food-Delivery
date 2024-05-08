package com.food.Dao;

import java.util.List;

import com.food.Entity.User;

public interface UserDao {
	
	public List<User> getAll();
	
	public User getUser(User u);
	
	public int Insert(User u);
	
	

}
