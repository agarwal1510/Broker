package com.sapient.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import org.apache.commons.dbcp.BasicDataSource;
public class ConnectionUtil {
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "root";
	private static final String DB_NAME = "ets";
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/" + DB_NAME;
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static Connection conn = null;

	public ConnectionUtil() {

	}

	public static Connection getConnection() {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("SQL status2: "+e.getErrorCode()+System.lineSeparator()+"Error Message :"+e.getMessage());
		}

		return conn;
	}
	public static void closeConnection() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL status3: "+e.getErrorCode()+System.lineSeparator()+"Error Message :"+e.getMessage());
		}
	}

}