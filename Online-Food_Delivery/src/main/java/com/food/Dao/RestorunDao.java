package com.food.Dao;

import java.util.List;

import com.food.Entity.Restorunt;

public interface RestorunDao {

	public List<Restorunt> getAll();

	public Restorunt getRestorunt(Restorunt r);

	public int Insert(Restorunt r);

}
