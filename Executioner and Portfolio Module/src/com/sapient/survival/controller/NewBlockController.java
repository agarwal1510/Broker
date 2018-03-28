package com.sapient.survival.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sapient.survival.dao.BlockDao;
import com.sapient.survival.dao.OrderDao;
import com.sapient.survival.pojo.Block;
import com.sapient.survival.pojo.Order;

public class NewBlockController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewBlockController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BigDecimal totalQuantity = new BigDecimal(0);
		double avgPrice = 0;
		double totalPrice = 0;
		int count = 0;
		int res = 0;
		BigDecimal allocatedQuantity = new BigDecimal(0);
		BlockDao obj = new BlockDao();
		Block b = new Block();
		Order o = new Order();
		String orders[] = request.getParameterValues("orderId");
		OrderDao od = new OrderDao();
		List<Order> oList = new ArrayList<Order>();
		String side = null;
		String symbol = null;
		try {
			o = od.getOrders(orders[0]);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		side = o.getSide();
		symbol = o.getSymbol();
		for (int i = 0; i < orders.length; i++) {
			try {
				o = od.getOrders(orders[i]);
				totalQuantity = totalQuantity.add(o.getTotalQuantity());
				allocatedQuantity = allocatedQuantity.add(o
						.getAllocatedQuantity());
				if (o.getOrderType().equalsIgnoreCase("limit price")) {
					totalPrice = totalPrice + o.getLimitPrice();
				} else {
					totalPrice = totalPrice + o.getExecutedPrice();
				}
				avgPrice = totalPrice / (orders.length);
				oList.add(o);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		for (Order or : oList) {
			if (or.getSide().equalsIgnoreCase(side)
					&& or.getSymbol().equalsIgnoreCase(symbol)) {
				count++;
			}
		}
		if (count == orders.length) {
			b.setTraderId(o.getTraderId());
			b.setTotalQuantity(totalQuantity);
			b.setAllocatedQuantity(allocatedQuantity);
			b.setAvgPrice(avgPrice);
			b.setSide(o.getSide());
			b.setBlockSymbol(o.getSymbol());
			b.setStatus("new");
			res = obj.createNewBlock(b, oList);
		}
		if (res == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("/viewBlocks");
			rd.forward(request, response);
		}
		if (res == 0) {
			request.setAttribute("message", "Block criteria Not satisfied");
			RequestDispatcher rd = request.getRequestDispatcher("/viewOrders");
			rd.forward(request, response);
		}
	}

}
