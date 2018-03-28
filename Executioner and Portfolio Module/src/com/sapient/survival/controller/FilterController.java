package com.sapient.survival.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.survival.dao.OrderDao;
import com.sapient.survival.exceptions.InvalidOrderException;
import com.sapient.survival.pojo.Order;

public class FilterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FilterController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String symbol = request.getParameter("symbol");
		String side = request.getParameter("side");
		HttpSession session = request.getSession(false);
		BigDecimal uid = (BigDecimal) session.getAttribute("userId");
		if (!symbol.isEmpty() && !side.isEmpty()) {
			OrderDao obj = new OrderDao();
			List<Order> list = null;
			try {
				list = obj.getOrders(symbol, side, uid);
			} catch (InvalidOrderException e) {
				System.out.println(e.getMessage());
			}
			request.setAttribute("orderList", list);
			RequestDispatcher rd = request
					.getRequestDispatcher("ViewOpenOrder.jsp");
			rd.forward(request, response);
		} else if (!symbol.isEmpty()) {
			OrderDao obj = new OrderDao();
			List<Order> list = null;
			try {
				list = obj.getOrders1(symbol, uid);
			} catch (InvalidOrderException e) {
				System.out.println(e.getMessage());
			}
			request.setAttribute("orderList", list);
			RequestDispatcher rd = request
					.getRequestDispatcher("ViewOpenOrder.jsp");
			rd.forward(request, response);
		} else if (!side.isEmpty()) {
			OrderDao obj = new OrderDao();
			List<Order> list = null;
			try {
				list = obj.getOrders2(side, uid);
			} catch (InvalidOrderException e) {
				System.out.println(e.getMessage());
			}
			request.setAttribute("orderList", list);
			RequestDispatcher rd = request
					.getRequestDispatcher("ViewOpenOrder.jsp");
			rd.forward(request, response);
		}
	}

}
