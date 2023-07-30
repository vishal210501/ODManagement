package com.entity;

public class Custmor {

	private int Cid;
	private String Fname;
	private String Lname;
	private long Mno;
	private String Email;
	private String Address;

	public Custmor() {
		super();

	}

	public Custmor(int Cid, String Fname, String Lname, long Mno, String Email, String Address) {
		super();
		this.Cid = Cid;
		this.Fname = Fname;
		this.Lname = Lname;
		this.Mno = Mno;
		this.Email = Email;
		this.Address = Address;
	}

	public int getCid() {
		return Cid;
	}

	public void setCid(int Cid) {
		this.Cid = Cid;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String Fname) {
		this.Fname = Fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String Lname) {
		this.Lname = Lname;
	}

	public long getMno() {
		return Mno;
	}

	public void setMno(long Mno) {
		this.Mno = Mno;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	@Override
	public String toString() {
		return "Custmor [cid=" + Cid + ", Fname=" + Fname + ", Lname=" + Lname + ", Mno=" + Mno + ", Email=" + Email
				+ ", Address=" + Address + "]";
	}

}
