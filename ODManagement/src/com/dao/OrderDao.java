package com.dao;

import com.entity.Order;

public interface OrderDao {

	public void AddOrder(Order o);

	public void DeleteOrder(int oid);

	public void UpdateOrder(int oid);

	public Order GetOrderByID(int oid);

	public void DisplayAllOrder();
}
