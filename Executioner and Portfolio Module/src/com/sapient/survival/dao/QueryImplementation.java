package com.sapient.survival.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sapient.survival.pojo.Order;
import com.sapient.survival.pojo.User;
import com.sapient.util.ConnectionUtil;

public class QueryImplementation {
	public Connection conn;

	public List<Order> viewOrder() {
		conn = ConnectionUtil.getConnection();
		List<Order> list = new ArrayList<Order>();

		try {
			PreparedStatement viewOrder = conn
					.prepareStatement(Query.viewAllOrder);
			ResultSet rs = viewOrder.executeQuery();

			while (rs.next()) {
				Order testOrders = new Order();
				testOrders.setOrderId(rs.getBigDecimal("Order_id"));
				testOrders.setSymbol(rs.getString("symbol"));
				testOrders.setSide(rs.getString("side"));
				testOrders.setSymbol(rs.getString("Symbol"));
				testOrders.setTotalQuantity(rs.getBigDecimal("total_quantity"));
				testOrders.setOrderType(rs.getString("order_type"));
				testOrders.setLimitPrice(rs.getDouble("limit_price"));
				testOrders.setStopPrice(rs.getDouble("stop_price"));
				testOrders.setAllocatedQuantity(rs
						.getBigDecimal("allocated_quantity"));
				testOrders.setTraderId(rs.getBigDecimal("trader_id"));
				testOrders.setStatus(rs.getString("status"));
				String traderName = fetchTraderName(testOrders.getTraderId());
				// testOrders.getTraderId())
				
				testOrders.setTrader(traderName);
				list.add(testOrders);
				System.out.println(list);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public List<Order> viewOrderBySide(String type) {
		conn = ConnectionUtil.getConnection();
		List<Order> list = new ArrayList<Order>();

		try {
			PreparedStatement viewOrder = conn
					.prepareStatement(Query.viewOrderByside);
			viewOrder.setString(1, type);
			ResultSet rs = viewOrder.executeQuery();

			while (rs.next()) {
				Order testOrders = new Order();
				testOrders.setOrderId(rs.getBigDecimal("Order_id"));
				testOrders.setSymbol(rs.getString("symbol"));
				testOrders.setSide(rs.getString("side"));
				testOrders.setSymbol(rs.getString("Symbol"));
				testOrders.setTotalQuantity(rs.getBigDecimal("total_quantity"));
				testOrders.setOrderType(rs.getString("order_type"));
				testOrders.setLimitPrice(rs.getDouble("limit_price"));
				testOrders.setStopPrice(rs.getDouble("stop_price"));
				testOrders.setAllocatedQuantity(rs
						.getBigDecimal("allocated_quantity"));
				testOrders.setTraderId(rs.getBigDecimal("trader_id"));
				testOrders.setStatus(rs.getString("status"));
				String traderName = fetchTraderName(testOrders.getTraderId());
				// testOrders.getTraderId())
				
				testOrders.setTrader(traderName);
				list.add(testOrders);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public List<Order> viewOrderBySymbol(String symbol) {
		conn = ConnectionUtil.getConnection();
		List<Order> list = new ArrayList<Order>();

		try {
			PreparedStatement viewOrder = conn
					.prepareStatement(Query.viewOrderBySymbol);
			viewOrder.setString(1, symbol);
			ResultSet rs = viewOrder.executeQuery();

			while (rs.next()) {
				Order testOrders = new Order();
				testOrders.setOrderId(rs.getBigDecimal("Order_id"));
				testOrders.setSymbol(rs.getString("symbol"));
				testOrders.setSide(rs.getString("side"));
				testOrders.setSymbol(rs.getString("Symbol"));
				testOrders.setTotalQuantity(rs.getBigDecimal("total_quantity"));
				testOrders.setOrderType(rs.getString("order_type"));
				testOrders.setLimitPrice(rs.getDouble("limit_price"));
				testOrders.setStopPrice(rs.getDouble("stop_price"));
				testOrders.setAllocatedQuantity(rs
						.getBigDecimal("allocated_quantity"));
				testOrders.setTraderId(rs.getBigDecimal("trader_id"));
				testOrders.setStatus(rs.getString("status"));
				String traderName = fetchTraderName(testOrders.getTraderId());
				// testOrders.getTraderId())
				
				testOrders.setTrader(traderName);
				list.add(testOrders);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Order> viewOrderBySymbolSide(String symbol, String side) {
		conn = ConnectionUtil.getConnection();
		List<Order> list = new ArrayList<Order>();

		try {
			PreparedStatement viewOrder = conn
					.prepareStatement(Query.viewOrderBySymbolSide);
			viewOrder.setString(1, symbol);
			viewOrder.setString(2, side);

			ResultSet rs = viewOrder.executeQuery();

			while (rs.next()) {
				Order testOrders = new Order();
				testOrders.setOrderId(rs.getBigDecimal("Order_id"));
				testOrders.setSymbol(rs.getString("symbol"));
				testOrders.setSide(rs.getString("side"));
				testOrders.setSymbol(rs.getString("Symbol"));
				testOrders.setTotalQuantity(rs.getBigDecimal("total_quantity"));
				testOrders.setOrderType(rs.getString("order_type"));
				testOrders.setLimitPrice(rs.getDouble("limit_price"));
				testOrders.setStopPrice(rs.getDouble("stop_price"));
				testOrders.setAllocatedQuantity(rs
						.getBigDecimal("allocated_quantity"));
				testOrders.setTraderId(rs.getBigDecimal("trader_id"));
				testOrders.setStatus(rs.getString("status"));
				String traderName = fetchTraderName(testOrders.getTraderId());
				// testOrders.getTraderId())
				
				testOrders.setTrader(traderName);
				list.add(testOrders);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}
	public ResultSet fetchTraderDeatails(){
		conn = ConnectionUtil.getConnection();
		ResultSet rs=null;
		try {
			PreparedStatement trd=conn.prepareStatement(Query.fetchTraderDetails);
			rs=trd.executeQuery();
			
			return rs;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return rs;
		
	}
	public List<User> fetchTraderDetails(){
		conn = ConnectionUtil.getConnection();
		List<User> lst=new ArrayList<>();
		try {
			PreparedStatement stmt=conn.prepareStatement(Query.fetchTraderAndBoth);
			ResultSet rs=stmt.executeQuery();
			User u = null;
			while(rs.next()){
				u = new User();
				u.setName(rs.getString("name"));
				u.setUserId(rs.getBigDecimal("user_id"));
				lst.add(u);
			}
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		System.out.println(lst);
		return lst;
	}

	public void deleteOrder(BigDecimal orderId) {
		conn = ConnectionUtil.getConnection();

		try {
			PreparedStatement deleteOrder = conn
					.prepareStatement(Query.deleteOrder);
			deleteOrder.setString(1, "deleted");

			deleteOrder.setBigDecimal(2, orderId);
			deleteOrder.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	public void symbolValidator(String sym) {
		conn = ConnectionUtil.getConnection();
		try {

			PreparedStatement valid = conn
					.prepareStatement(Query.symbolValidator);
			valid.setString(1, "symbol");
			valid.executeQuery();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	

	public ResultSet fetchTraderName() {
		conn = ConnectionUtil.getConnection();
		ResultSet rs = null;
		try {
			PreparedStatement getTrader = conn
					.prepareStatement(Query.fetchTraderName);
			rs = getTrader.executeQuery();

			return rs;

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return rs;

	}
	
	public String fetchTraderName(BigDecimal trade_Id) {
		conn = ConnectionUtil.getConnection();
		ResultSet rs = null;
		String traderName = null;
		try {
			PreparedStatement getTrader = conn
					.prepareStatement(Query.fetchTraderName);
			getTrader.setBigDecimal(1,trade_Id);
			rs = getTrader.executeQuery();
			traderName = rs.getString("name");

			

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return traderName;

	}
	
	
	public boolean quantityValidator(String sym, BigDecimal quantity){
		conn = ConnectionUtil.getConnection();
		ResultSet rs = null;
		try {
			
			PreparedStatement valid= conn.prepareStatement(Query.quantityValidator);
			valid.setString(1,sym);
			rs=valid.executeQuery();
				rs.next();
		
			if(rs.getBigDecimal(1).compareTo(quantity)==1||rs.getBigDecimal(1).compareTo(quantity)==0){
				return true;
			}
			else{
				return false;
			}
		  
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return true;	
		
	}


public ResultSet fetchSymbol(){
		conn=ConnectionUtil.getConnection();
		ResultSet symbols=null;
		try {
			PreparedStatement fetch=conn.prepareStatement(Query.fetchSecurity);
			symbols =fetch.executeQuery();
			
			return symbols;
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return symbols;
		
	}



public void insertOrder(Order obj) {
		conn = ConnectionUtil.getConnection();

		PreparedStatement addOrder;
		try {
			addOrder = conn.prepareStatement(Query.addOrder);
			
			BigDecimal allocated = new BigDecimal("0");

			BigDecimal portId = obj.getPortfolioId();

			addOrder.setString(1, obj.getSymbol());
			addOrder.setBigDecimal(2, portId);
			addOrder.setString(3, obj.getSide());
			addOrder.setBigDecimal(4, obj.getTotalQuantity());
			addOrder.setBigDecimal(5, allocated);
			addOrder.setString(6, obj.getOrderType());
			addOrder.setDouble(7, obj.getLimitPrice());
			addOrder.setDouble(8, obj.getStopPrice());
			

			addOrder.setBigDecimal(9, obj.getTraderId());
			addOrder.setString(10, "new");

			addOrder.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}


public ResultSet fetchTrader() {
		conn = ConnectionUtil.getConnection();
		ResultSet rs = null;
		try {
			PreparedStatement getTrader = conn
					.prepareStatement(Query.fetchTrader);
			//getTrader.setString(1, "trader");

			rs = getTrader.executeQuery();

			return rs;

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return rs;

	}

}
