package com.dao;

import com.entity.Custmor;

public interface CustmorDao {

	public void AddCustmor(Custmor c);

	public void DeleteCustmor(int cid);

	public void UpdateCustmor(int cid);

	public Custmor GetCustmorByID(int cid);

	public void DisplayAllCustmor();

}
