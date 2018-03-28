package com.sapient.survival.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.survival.pojo.Order;
import com.sapient.util.ConnectionUtil;

import java.sql.Connection;

public class ViewOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewOrders() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String bidID = request.getParameter("bid");
		System.out.println(bidID);
		List<Order> view = new ArrayList<>();
		BigDecimal bid = new BigDecimal(bidID.replaceAll(",", ""));
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql;
			sql = "select * from orders where Order_id in (select order_id from ordersblockmap where block_id=?)";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setBigDecimal(1, bid);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				Order tmpOrder = new Order();
				System.out.println((rs.getString("symbol")));
				tmpOrder.setSymbol(rs.getString("symbol"));
				tmpOrder.setSide(rs.getString("side"));
				tmpOrder.setTotalQuantity(rs.getBigDecimal("total_quantity"));
				tmpOrder.setAllocatedQuantity(rs
						.getBigDecimal("allocated_quantity"));
				tmpOrder.setOrderType(rs.getString("order_type"));
				tmpOrder.setExecutedPrice(rs.getDouble("executed_price"));
				tmpOrder.setStatus(rs.getString("status"));
				view.add(tmpOrder);
			}
			rs.close();
			prepStmt.close();
			conn.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		if (view.isEmpty()) {
			request.setAttribute("errMsg", "List is Empty");
			request.getRequestDispatcher("DisplayOrders.jsp").forward(request,
					response);
		} else {
			request.setAttribute("Blocklist", view);
			request.getRequestDispatcher("DisplayOrders.jsp").forward(request,
					response);
		}
	}
}
