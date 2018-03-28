package com.sapient.survival.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.survival.exceptions.InvalidOrderException;
import com.sapient.survival.pojo.Order;
import com.sapient.util.ConnectionUtil;

public class OrderDao {

	public List<Order> getOrders(BigDecimal uid) throws InvalidOrderException{
		List<Order> od = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			   conn = ConnectionUtil.getConnection();
			   String sql;
			      sql = "SELECT o.Order_id,o.side,o.symbol,o.total_quantity,o.order_type,o.limit_price,o.stop_price,o.executed_price,o.status,u.name,p.name FROM orders o, user u, portfolio p where u.user_id = p.user_id and p.Portfolio_id = o.portfolio_id and o.trader_id=? and o.status=?";  /*attributes may be different */
			  /* String sql2 ="Select u.name from users u, portfolio p where p.user_id = u.user_id";*/
			      stmt = conn.prepareStatement(sql);
			  // Integer i = (Integer)session.getAttribute("userName"); /*can change depending upon session created */
			   stmt.setBigDecimal(1, uid);
			   stmt.setString(2,"new");
			   ResultSet rs = stmt.executeQuery();
			   Order o = null;
			   while(rs.next()){
				   o = new Order();
				   o.setOrderId(rs.getBigDecimal(1));
				   o.setSide(rs.getString(2));
				   o.setSymbol(rs.getString(3));
				   o.setTotalQuantity(rs.getBigDecimal(4));
				   o.setOrderType(rs.getString(5));
				   o.setLimitPrice(rs.getDouble(6));
				   o.setStopPrice(rs.getDouble(7));
				   o.setExecutedPrice(rs.getDouble(8));
				   o.setStatus(rs.getString(9));
				   o.setPortfolioManagerName(rs.getString(10));
				   o.setPortfolioName(rs.getString(11));
				   
				   od.add(o);
			   }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		if(od.isEmpty()) throw new InvalidOrderException("The List is Empty for fetching all orders");
		return od;
	}
	
	public Order getOrders(String orderId) throws ParseException{
		BigDecimal oid = new BigDecimal(orderId.replaceAll(",", ""));
		Connection conn = null;
		PreparedStatement stmt = null;
		Order o = null;
		try{
			   conn = ConnectionUtil.getConnection();
			   String sql;
			      sql = "Select * from orders where Order_id=?";  /*attributes may be different */
			  /* String sql2 ="Select u.name from users u, portfolio p where p.user_id = u.user_id";*/
			      stmt = conn.prepareStatement(sql);
			  // Integer i = (Integer)session.getAttribute("userName"); /*can change depending upon session created */
			   stmt.setBigDecimal(1, oid);
			   ResultSet rs = stmt.executeQuery();
			   if(rs.next()){
				   o = new Order();
				   o.setOrderId(rs.getBigDecimal(1));
				   o.setSymbol(rs.getString(2));
				   o.setPortfolioId(rs.getBigDecimal(3));
				   o.setSide(rs.getString(4));
				   o.setTotalQuantity(rs.getBigDecimal(5));
				   o.setAllocatedQuantity(rs.getBigDecimal(6));
				   o.setOrderType(rs.getString(7));
				   o.setLimitPrice(rs.getDouble(8));
				   o.setStopPrice(rs.getDouble(9));
				   o.setExecutedPrice(rs.getDouble(10));
				   o.setTraderId(rs.getBigDecimal(11));
				   o.setStatus(rs.getString(12));
			   }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return o;
	}
	
	public List<Order> getOrders(String symbol,String side,BigDecimal uid) throws InvalidOrderException{
		List<Order> od = new ArrayList<Order>();
		Connection conn = null;
		
		PreparedStatement stmt = null;
		try{
			   conn = ConnectionUtil.getConnection();
			   String sql;
			      sql = "SELECT o.Order_id,o.side,o.symbol,o.total_quantity,o.order_type,o.limit_price,o.stop_price,o.executed_price,o.status,u.name,p.name FROM orders o, user u, portfolio p where u.user_id = p.user_id and p.Portfolio_id = o.portfolio_id and o.trader_id=? and o.status=? and o.side=? and o.symbol=?";  /*attributes may be different */
			  /* String sql2 ="Select u.name from users u, portfolio p where p.user_id = u.user_id";*/
			      stmt = conn.prepareStatement(sql);
			  // Integer i = (Integer)session.getAttribute("userName"); /*can change depending upon session created */
			   stmt.setBigDecimal(1, uid);
			   stmt.setString(2,"new");
			   stmt.setString(3,side);
			   stmt.setString(4,symbol);
			   ResultSet rs = stmt.executeQuery();
			   Order o = null;
			   while(rs.next()){
				   o = new Order();
				   o.setOrderId(rs.getBigDecimal(1));
				   o.setSide(rs.getString(2));
				   o.setSymbol(rs.getString(3));
				   o.setTotalQuantity(rs.getBigDecimal(4));
				   o.setOrderType(rs.getString(5));
				   o.setLimitPrice(rs.getDouble(6));
				   o.setStopPrice(rs.getDouble(7));
				   o.setExecutedPrice(rs.getDouble(8));
				   o.setStatus(rs.getString(9));
				   o.setPortfolioManagerName(rs.getString(10));
				   o.setPortfolioName(rs.getString(11));
				   od.add(o);
			   }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		if(od.isEmpty()) throw new InvalidOrderException("Couldn't fetch order for search pattern from DB.");
		return od;
	}
	
	public List<Order> getOrders1(String symbol,BigDecimal uid) throws InvalidOrderException{
		List<Order> od = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			   conn = ConnectionUtil.getConnection();
			   String sql;
			      sql = "SELECT o.Order_id,o.side,o.symbol,o.total_quantity,o.order_type,o.limit_price,o.stop_price,o.executed_price,o.status,u.name,p.name FROM orders o, user u, portfolio p where u.user_id = p.user_id and p.Portfolio_id = o.portfolio_id and o.trader_id=?  and o.status=? and o.symbol=?";  /*attributes may be different */
			      stmt = conn.prepareStatement(sql);
			  // Integer i = (Integer)session.getAttribute("userName"); /*can change depending upon session created */
			   stmt.setBigDecimal(1, uid);
			   stmt.setString(2,"new");
			   stmt.setString(3,symbol);
			   System.out.println(stmt);
			   ResultSet rs = stmt.executeQuery();
			   Order o = null;
			   while(rs.next()){
				   o = new Order();
				   o.setOrderId(rs.getBigDecimal(1));
				   o.setSide(rs.getString(2));
				   o.setSymbol(rs.getString(3));
				   o.setTotalQuantity(rs.getBigDecimal(4));
				   o.setOrderType(rs.getString(5));
				   o.setLimitPrice(rs.getDouble(6));
				   o.setStopPrice(rs.getDouble(7));
				   o.setExecutedPrice(rs.getDouble(8));
				   o.setStatus(rs.getString(9));
				   o.setPortfolioManagerName(rs.getString(10));
				   o.setPortfolioName(rs.getString(11));
				   od.add(o);
			   }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		if(od.isEmpty()) throw new InvalidOrderException("Couldn't fetch order for search by symbol pattern from DB.");
		return od;
	}
	
	public List<Order> getOrders2(String side,BigDecimal uid) throws InvalidOrderException{
		List<Order> od = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			   conn = ConnectionUtil.getConnection();
			   String sql;
			      sql = "SELECT o.Order_id,o.side,o.symbol,o.total_quantity,o.order_type,o.limit_price,o.stop_price,o.executed_price,o.status,u.name,p.name FROM orders o, user u, portfolio p where u.user_id = p.user_id and p.Portfolio_id = o.portfolio_id and o.trader_id=?  and o.status=? and o.side=?";  /*attributes may be different */
			  /* String sql2 ="Select u.name from users u, portfolio p where p.user_id = u.user_id";*/
			      stmt = conn.prepareStatement(sql);
			  // Integer i = (Integer)session.getAttribute("userName"); /*can change depending upon session created */
			   stmt.setBigDecimal(1, uid);
			   stmt.setString(2,"new");
			   stmt.setString(3,side);
			   ResultSet rs = stmt.executeQuery();
			   Order o = null;
			   while(rs.next()){
				   o = new Order();
				   o.setOrderId(rs.getBigDecimal(1));
				   o.setSide(rs.getString(2));
				   o.setSymbol(rs.getString(3));
				   o.setTotalQuantity(rs.getBigDecimal(4));
				   o.setOrderType(rs.getString(5));
				   o.setLimitPrice(rs.getDouble(6));
				   o.setStopPrice(rs.getDouble(7));
				   o.setExecutedPrice(rs.getDouble(8));
				   o.setStatus(rs.getString(9));
				   o.setPortfolioManagerName(rs.getString(10));
				   o.setPortfolioName(rs.getString(11));
				   od.add(o);
			   }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		if(od.isEmpty()) throw new InvalidOrderException("Couldn't fetch order for search by side pattern from DB.");
		return od;
	}
}
