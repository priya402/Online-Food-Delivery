package com.food.Dao;

import java.util.List;

import com.food.Entity.MenuItem;

public interface MenuDao {

	public List<MenuItem> getAllMenu();

	public MenuItem getMenu(int mid);

	public int addMenu(MenuItem menu);

	public int updateMenu(MenuItem menu);
	
	public int deleteMenu(MenuItem menu);

}
