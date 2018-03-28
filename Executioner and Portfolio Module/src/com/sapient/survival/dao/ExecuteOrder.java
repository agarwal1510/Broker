package com.sapient.survival.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sapient.util.ConnectionUtil;

public class ExecuteOrder implements FillImplementation {

	@Override
	public void updateBlockStatus() {
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			PreparedStatement stmt1 = conn
					.prepareStatement(Query.changeStatus1);
			PreparedStatement stmt2 = conn
					.prepareStatement(Query.changeStatus2);
			int result1 = stmt1.executeUpdate();
			int result2 = stmt2.executeUpdate();
			updateOrderStaus();
			if (result1 != 0 && result2 != 0) {
				System.out.println("changed status of block...");
			}
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrderStaus() {
		Connection conn = null;

		try {
			conn = ConnectionUtil.getConnection();
			BigDecimal big1 = new BigDecimal(500);
			BigDecimal big2 = new BigDecimal(30005);
			PreparedStatement stmt1 = conn
					.prepareStatement(Query.changeOrderStatus);
			stmt1.setBigDecimal(1, big1);
			stmt1.setString(2, "fully executed");
			stmt1.setBigDecimal(3, big2);
			int result1 = stmt1.executeUpdate();
			if (result1 != 0) {
				System.out.println("changed status of order1...");
			}
			BigDecimal big3 = new BigDecimal(0);
			BigDecimal big4 = new BigDecimal(30003);
			PreparedStatement stmt2 = conn
					.prepareStatement(Query.changeOrderStatus);
			stmt2.setBigDecimal(1, big3);
			stmt2.setString(2, "partially executed");
			stmt2.setBigDecimal(3, big4);
		//	int result2 = stmt2.executeUpdate();
			if (result1 != 0) {
				System.out.println("changed status of order2...");
			}
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}

	}

}
