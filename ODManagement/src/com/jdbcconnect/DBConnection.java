package com.jdbcconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/orderdb";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";

	static Connection con = null;

	public static Connection getConnect() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("driver loaded.........................................");
			con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			System.out.println("connection done.........................................");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static void main(String[] args) {
		getConnect();
	}

}