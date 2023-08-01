package com.daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import com.dao.OrderDao;
import com.entity.Order;
import com.jdbcconnect.DBConnection;

public class OrderDaoImpl implements OrderDao {

	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;

	static Scanner sc = new Scanner(System.in);

	public OrderDaoImpl() {
		con = DBConnection.getConnect();
//		System.out.println("connection done..............");
		try {
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void AddOrder(Order o) {
		try {
			st = con.createStatement();
			float cost = 0;
			ResultSet rs = st.executeQuery("select * from  item");
			while (rs.next()) {
				int id = rs.getInt(1);
				if (o.getItem_id() == id) {
					cost = rs.getFloat(3);
//					System.out.println(cost);
				}
			}

			pst = con.prepareStatement("insert into Orderdetails values(?,?,?,?,?,?,?)");
			pst.setInt(1, o.getOid());
			pst.setInt(2, o.getItem_id());
			pst.setInt(3, o.getCid());
			pst.setInt(4, o.getQty());

			float Cost1 = o.getQty() * cost;
//			System.out.println(Cost1);
			pst.setFloat(5, Cost1);

			pst.setString(6, o.getOstatus());
			pst.setString(7, o.getPayStatus());

			int NoOfRowsAdded = pst.executeUpdate();
			if (NoOfRowsAdded > 0) {
				System.out.println("order added");
			} else {
				System.out.println(
						"error..................................................................................................................................");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void DeleteOrder(int oid) {
		try {
			pst = con.prepareStatement("delete from Orderdetails where order_id=?");
			pst.setInt(1, oid);

			int NoOfRowsDeleted = pst.executeUpdate();
			if (NoOfRowsDeleted > 0) {
				System.out.println("order deleted");
			} else {
				System.out.println("error....................");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void UpdateOrder(int oid) {
		try {
			Order o = new Order();
			o = GetOrderByID(oid);
			if (o != null) {
				System.out.println("old details of order");
				System.out.println(o);
				System.out.println(
						"............................................................................................");
				System.out.println(" enter new quantity of item");
				int Qty = sc.nextInt();

				pst = con.prepareStatement("update Orderdetails set quantity=? where order_id=?");
				pst.setInt(1, Qty);
				pst.setInt(2, oid);

				int NoOfRowsUpdated = pst.executeUpdate();
				if (NoOfRowsUpdated > 0) {
					System.out.println("new quantity is added");

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
	public Order GetOrderByID(int oid) {
		try {
			pst = con.prepareStatement("select*from Orderdetails where order_id=?");
			pst.setInt(1, oid);

			rs = pst.executeQuery();
			if (rs.next()) {
				Order o = new Order();
				o.setOid(rs.getInt(1));
				o.setCid(rs.getInt(2));
				o.setItem_id(rs.getInt(3));
				o.setQty(rs.getInt(4));
				o.setTotalCost(rs.getFloat(5));
				o.setOstatus(rs.getString(6));
				o.setPayStatus(rs.getString(7));
				return o;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void DisplayAllOrder() {
		try {
			rs = st.executeQuery("select*from Orderdetails");
			System.out.println(
					"...................................................................................................................................................");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "   " + rs.getInt(2) + "   " + rs.getInt(3) + "   " + rs.getInt(4)
						+ "   " + rs.getFloat(5) + "   " + rs.getString(6) + "   " + rs.getString(7));
				System.out.println(
						"...............................................................................................................................................");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
