package com.sapient.survival.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sapient.survival.exceptions.InvalidBlockException;
import com.sapient.survival.exceptions.InvalidBlockUpdate;
import com.sapient.survival.pojo.Block;
import com.sapient.survival.pojo.Order;
import com.sapient.util.ConnectionUtil;

public class BlockDao {

	@SuppressWarnings("static-access")
	public int createNewBlock(Block b, List<Order> oList) {
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		BigDecimal blockId = null;
		int rs = 0;
		int res = 0;
		try {
			conn = ConnectionUtil.getConnection();
			String sql = "Insert into blocks values (NULL,?,?,?,?,?,?,?)"; /*
																			 * attributes
																			 * may
																			 * be
																			 * different
																			 */
			stmt = conn.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
			stmt.setBigDecimal(1, b.getTraderId());
			stmt.setString(2, b.getSide());
			stmt.setBigDecimal(3, b.getTotalQuantity());
			stmt.setBigDecimal(4, b.getAllocatedQuantity());
			stmt.setDouble(5, b.getAvgPrice());
			stmt.setString(6, b.getStatus());
			stmt.setString(7, b.getBlockSymbol());
			rs = stmt.executeUpdate();
			if (rs == 1) {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					blockId = generatedKeys.getBigDecimal(1);
				}
				for (Order or : oList) {
					String sql2 = "Insert into ordersblockmap values (NULL,?,?)";
					stmt2 = conn.prepareStatement(sql2);
					stmt2.setBigDecimal(1, blockId);
					stmt2.setBigDecimal(2, or.getOrderId());
					res = stmt2.executeUpdate();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	public List<Block> getBlocks() throws InvalidBlockException {
		List<Block> blk = new ArrayList<Block>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionUtil.getConnection();
			String sql;
			sql = "select * from blocks"; /* attributes may be different */
			stmt = conn.prepareStatement(sql);
			// Integer i = (Integer)session.getAttribute("userName"); /*can
			// change depending upon session created */
			ResultSet rs = stmt.executeQuery();
			Block b = null;
			while (rs.next()) {
				b = new Block();
				b.setSide(rs.getString(3));
				b.setBlockId(rs.getBigDecimal(1));
				b.setBlockSymbol(rs.getString(8));
				b.setTraderId(rs.getBigDecimal(2));
				b.setTotalQuantity(rs.getBigDecimal(4));
				b.setAllocatedQuantity(rs.getBigDecimal(5));
				b.setAvgPrice(rs.getDouble(6));
				b.setStatus(rs.getString(7));
				blk.add(b);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(blk.isEmpty()) throw new InvalidBlockException("Block list fetched from DB is empty.");
		return blk;
	}

	public int sendBlockForExecution(String blocks[]) throws InvalidBlockUpdate{
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmtToUpdateOrderTable = null;
		int rs = 0;
		try {
			conn = ConnectionUtil.getConnection();
			for (int i = 0; i < blocks.length; i++) {
				BigDecimal bid = new BigDecimal(blocks[i].replaceAll(",", ""));
				String sql = "update blocks set status='Sent For Execution' where Block_id=?";
				String SqlToUpdateOrderTable = "update orders set status = 'sent for execution' where Order_Id in (select Order_id from ordersblockmap where Block_id=?)";
				stmt = conn.prepareStatement(sql);
				stmt.setBigDecimal(1, bid);
				rs = stmt.executeUpdate();
				if (rs == 1) {
					stmtToUpdateOrderTable = conn
							.prepareStatement(SqlToUpdateOrderTable);
					stmtToUpdateOrderTable.setBigDecimal(1, bid);
					stmtToUpdateOrderTable.executeUpdate();
				}else throw new InvalidBlockUpdate();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rs;
	}

}