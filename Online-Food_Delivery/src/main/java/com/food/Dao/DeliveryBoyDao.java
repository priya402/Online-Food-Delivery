package com.food.Dao;

import java.util.List;

import com.food.Entity.DeliveryBoy;

public interface DeliveryBoyDao {
	public List<DeliveryBoy> getall();
	public int InfoUpdate(DeliveryBoy boy);
	public int InfoDelete(int i);
	public int InsertInfo(DeliveryBoy boy);

}
