package com.entity;

public class Item {

	private int Itemid;
	private String Iname;
	private float Cost;

	public Item() {
		super();

	}

	public Item(int Itemid, String Iname, float Cost) {
		super();
		this.Itemid = Itemid;
		this.Iname = Iname;
		this.Cost = Cost;
	}

	public int getItemid() {
		return Itemid;
	}

	public void setItemid(int Itemid) {
		this.Itemid = Itemid;
	}

	public String getIname() {
		return Iname;
	}

	public void setIname(String Iname) {
		this.Iname = Iname;
	}

	public float getCost() {
		return Cost;
	}

	public void setCost(float Cost) {
		this.Cost = Cost;
	}

	@Override
	public String toString() {
		return "Item [Itemid=" + Itemid + ", Iname=" + Iname + ", Cost=" + Cost + "]";
	}

}
