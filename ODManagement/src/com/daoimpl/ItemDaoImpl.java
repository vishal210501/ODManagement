package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import com.dao.ItemDao;
import com.entity.Item;
import com.jdbcconnect.DBConnection;

public class ItemDaoImpl implements ItemDao {

	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;

	static Scanner sc = new Scanner(System.in);

	public ItemDaoImpl() {
		con = DBConnection.getConnect();
//		System.out.println("connection done.............................");
		try {
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void AddItem(Item I) {
		try {
			pst = con.prepareStatement("insert into Item values(?,?,?)");
			pst.setInt(1, I.getItemid());
			pst.setString(2, I.getIname());
			pst.setFloat(3, I.getCost());

			int NoOfRowsAdded = pst.executeUpdate();
			if (NoOfRowsAdded > 0) {
				System.out.println("new item added");
			} else {
				System.out.println("error");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void DeleteItem(int itemid) {
		try {
			pst = con.prepareStatement("delete from Item where item_id =?");
			pst.setInt(1, itemid);
			int NoOfRowsDeleted = pst.executeUpdate();
			if (NoOfRowsDeleted > 0) {
				System.out.println("item is deleted");
			} else {
				System.out.println("error....");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void UpdateItem(int itemid) {
		try {
			Item i = new Item();
			i = GetItemByID(itemid);
			if (i != null) {
				System.out.println("old details of item");
				System.out.println(i);
				System.out.println(
						"............................................................................................");
				System.out.println(" enter new cost item");
				float Cost = sc.nextFloat();
				pst = con.prepareStatement("Update Item set Cost=? where item_id=?");
				pst.setFloat(1, Cost);
				pst.setInt(2, itemid);

				int NoOfRowsUpdated = pst.executeUpdate();
				if (NoOfRowsUpdated > 0) {
					System.out.println("new Cost is added");
				} else {
					System.out.println("error......");
				}
			} else {
				System.out.println("item id doesnt exist.......");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Item GetItemByID(int itemid) {
		try {
			pst = con.prepareStatement("select* from Item where item_id=?");
			pst.setInt(1, itemid);

			rs = pst.executeQuery();
			if (rs.next()) {
				Item i = new Item();
				i.setItemid(rs.getInt(1));
				i.setIname(rs.getString(2));
				i.setCost(rs.getFloat(3));
				return i;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void DisplayAllItem() {
		try {
			rs = st.executeQuery("select*from Item");
			System.out.println(
					"....................................................................................................................................................");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "   " + rs.getFloat(3));
				System.out.println(
						"...............................................................................................................................................");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
