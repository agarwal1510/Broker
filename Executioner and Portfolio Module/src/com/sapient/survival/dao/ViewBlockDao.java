package com.sapient.survival.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sapient.survival.pojo.Block;
import com.sapient.util.ConnectionUtil;

public class ViewBlockDao {

	public ArrayList<Object> viewBlock() throws SQLException {
		ArrayList<Object> view = new ArrayList<Object>();
		Connection conn;
		try {
			conn = ConnectionUtil.getConnection();
			String sql;
			sql = "select * from blocks where status='new'";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				Block tempBlk = new Block();
				tempBlk.setSide(rs.getString("side"));
				tempBlk.setBlockId(rs.getBigDecimal("Block_id"));
				tempBlk.setBlockSymbol(rs.getString("block_symbol"));
				tempBlk.setTraderId(rs.getBigDecimal("trader_id"));
				tempBlk.setTotalQuantity(rs.getBigDecimal("total_quantity"));
				tempBlk.setAllocatedQuantity(rs
						.getBigDecimal("allocated_quantity"));
				tempBlk.setAvgPrice(rs.getDouble("average_price"));
				view.add(tempBlk);
			}

			rs.close();
			prepStmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
		} // end try
		return view;
	}
}
