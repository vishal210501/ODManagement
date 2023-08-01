package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dao.CustmorDao;
import com.entity.Custmor;
import com.jdbcconnect.DBConnection;

import java.util.*;

public class CustmorDaoImpl implements CustmorDao {

	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;

	static Scanner sc = new Scanner(System.in);

	public CustmorDaoImpl() {
		con = DBConnection.getConnect();
//		System.out.println("connection established...............................");
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	@Override
	public void AddCustmor(Custmor c) {
		try {
			pst = con.prepareStatement("insert into Custmor values(?,?,?,?,?,?)");
			pst.setInt(1, c.getCid());
			pst.setString(2, c.getFname());
			pst.setString(3, c.getLname());
			pst.setLong(4, c.getMno());
			pst.setString(5, c.getEmail());
			pst.setString(6, c.getAddress());

			int NoOfRowsAdded = pst.executeUpdate();
			if (NoOfRowsAdded > 0) {
				System.out.println("custmor added");
			} else {
				System.out.println("error....................");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void DeleteCustmor(int cid) {
		try {
			pst = con.prepareStatement("delete from  Custmor where cid=?");
			pst.setInt(1, cid);
			int NoOfRowsDeleted = pst.executeUpdate();
			if (NoOfRowsDeleted > 0) {
				System.out.println("custmor is deleted");
			} else {
				System.out.println("error");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void UpdateCustmor(int cid) {

		try {
			Custmor c = new Custmor();
			c = GetCustmorByID(cid);
			if (c != null) {
				System.out.println("old details of custmor");
				System.out.println(c);
				System.out.println(
						"............................................................................................");
				System.out.println(" enter new mobile number");
				long mno = sc.nextLong();
				pst = con.prepareStatement("update Custmor set mobileno=? where cid=?");
				pst.setLong(1, mno);
				pst.setInt(2, cid);

				int NoOfRowsUpdated = pst.executeUpdate();
				if (NoOfRowsUpdated > 0) {
					System.out.println("mobile number updates");
				} else {
					System.out.println("error...........................");
				}

			} else {
				System.out.println("Custmor id doestnt exist...................");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Custmor GetCustmorByID(int cid) {

		try {
			pst = con.prepareStatement("select* from Custmor where cid=?");
			pst.setInt(1, cid);

			rs = pst.executeQuery();
			if (rs.next()) {
				Custmor c = new Custmor();
				c.setCid(rs.getInt(1));
				c.setFname(rs.getString(2));
				c.setLname(rs.getString(3));
				c.setMno(rs.getLong(4));
				c.setEmail(rs.getString(5));
				c.setAddress(rs.getString(6));
				return c;

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void DisplayAllCustmor() {
		try {
			rs = st.executeQuery("select*from Custmor");
			System.out.println(
					"..........................................................................................................");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "   " + rs.getString(3) + "   "
						+ rs.getLong(4) + "   " + rs.getString(5) + "   " + rs.getString(6));
				System.out.println(
						"...........................................................................................................");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
