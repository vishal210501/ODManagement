package com.entity;

public class Order {

	private int Oid;
	private int Cid;
	private int Item_id;
	private int Qty;
	private float TotalCost;
	private String PayStatus;
	private String Ostatus;

	public Order() {
		super();

	}

	public Order(int oid, int cid, int item_id, int qty, float totalCost, String payStatus, String ostatus) {
		super();
		Oid = oid;
		Cid = cid;
		Item_id = item_id;
		Qty = qty;
		TotalCost = totalCost;
		PayStatus = payStatus;
		Ostatus = ostatus;
	}

	public int getOid() {
		return Oid;
	}

	public void setOid(int oid) {
		Oid = oid;
	}

	public int getCid() {
		return Cid;
	}

	public void setCid(int cid) {
		Cid = cid;
	}

	public int getItem_id() {
		return Item_id;
	}

	public void setItem_id(int item_id) {
		Item_id = item_id;
	}

	public int getQty() {
		return Qty;
	}

	public void setQty(int qty) {
		Qty = qty;
	}

	public float getTotalCost() {
		return TotalCost;
	}

	public void setTotalCost(float totalCost) {
		TotalCost = totalCost;
	}

	public String getPayStatus() {
		return PayStatus;
	}

	public void setPayStatus(String payStatus) {
		PayStatus = payStatus;
	}

	public String getOstatus() {
		return Ostatus;
	}

	public void setOstatus(String ostatus) {
		Ostatus = ostatus;
	}

	@Override
	public String toString() {
		return "Order [Oid=" + Oid + ", Cid=" + Cid + ", Item_id=" + Item_id + ", Qty=" + Qty + ", TotalCost="
				+ TotalCost + ", PayStatus=" + PayStatus + ", Ostatus=" + Ostatus + "]";
	}

}
