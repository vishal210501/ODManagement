package com.dao;

import com.entity.Item;

public interface ItemDao {
	public void AddItem(Item I);

	public void DeleteItem(int itemid);

	public void UpdateItem(int did);

	public Item GetItemByID(int itemid);

	public void DisplayAllItem();
}
