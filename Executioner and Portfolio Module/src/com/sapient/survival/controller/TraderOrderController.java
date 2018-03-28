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

public class TraderOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TraderOrderController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		BigDecimal uid = (BigDecimal) session.getAttribute("userId");
		OrderDao obj = new OrderDao();
		List<Order> list = null;
		try {
			list = obj.getOrders(uid);
		} catch (InvalidOrderException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("orderList", list);
		RequestDispatcher rd = request
				.getRequestDispatcher("ViewOpenOrder.jsp");
		rd.forward(request, response);
	}

}
