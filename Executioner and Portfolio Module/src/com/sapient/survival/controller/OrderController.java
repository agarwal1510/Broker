package com.sapient.survival.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.survival.dao.QueryImplementation;
import com.sapient.survival.pojo.Order;
import com.sapient.survival.pojo.User;

public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;

		String url = request.getServletPath();

		if (url.equals("/createorder")) {
			Order obj = new Order();
			QueryImplementation oi = new QueryImplementation();
			String sn = request.getParameter("symbol");
			obj.setSymbol(sn);
			String side = request.getParameter("side");
			obj.setSide(side);
			String qty = request.getParameter("quantity");
			BigDecimal quantity = new BigDecimal(qty.replaceAll(",", ""));
			obj.setTotalQuantity(quantity);
			session = request.getSession();
			obj.setPortfolioId((BigDecimal)session.getAttribute("portfolioId"));
			// boolean qtyValidator = oi.quantityValidator(sn, quantity);

			String ot = request.getParameter("orderType");
			obj.setOrderType(ot);
			// Double
			// mp=Double.parseDouble(request.getParameter("marketprice"));
			if (ot.equals("limitprice")) {
				Double lp = Double.parseDouble(request
						.getParameter("limitprice"));
				obj.setLimitPrice(lp);

			} else if (ot.equals("stopprice")) {
				Double sp = Double.parseDouble(request
						.getParameter("stopprice"));
				obj.setStopPrice(sp);

			} else if (ot.equals("limitstop")) {
				Double lp = Double.parseDouble(request
						.getParameter("limitprice"));
				obj.setLimitPrice(lp);

				Double sp = Double.parseDouble(request
						.getParameter("stopprice"));
				obj.setStopPrice(sp);

			}

			String traderid = request.getParameter("trader");
			BigDecimal tradeid = new BigDecimal(traderid.replaceAll(",", ""));
			obj.setTraderId(tradeid);

			QueryImplementation o = new QueryImplementation();
			List<User> lst = o.fetchTraderDetails();
			request.setAttribute("TraderList", lst);

			if (oi.quantityValidator(sn, quantity)) {
				oi.insertOrder(obj);
				request.setAttribute("successMsg", "Order Successfully Placed");
				request.getRequestDispatcher("CreateOrder.jsp").forward(
						request, response);
			} else {
				request.setAttribute("errMsg",
						"Insufficient Quantity: Quantity more than volume");
				request.getRequestDispatcher("CreateOrder.jsp").forward(
						request, response);
			}

		} else if (url.equals("/viewOrder")) {
			String side = request.getParameter("side");
			String symbol = request.getParameter("symbol");

			QueryImplementation qi = new QueryImplementation();
			// session = request.getSession();
			List<Order> list = null;

			if (side != null && !side.isEmpty() && symbol != null
					&& !symbol.isEmpty()) {

				list = qi.viewOrderBySymbolSide(symbol, side);
			} else if (side != null && !side.isEmpty()) {
				// show orders by side
				list = qi.viewOrderBySide(side);
			} else if (symbol != null && !symbol.isEmpty()) {
				// show orders by symbol only
				list = qi.viewOrderBySymbol(symbol);
			} else {
				// show all orders
				list = qi.viewOrder();
			}

			request.setAttribute("list", list);

			request.getRequestDispatcher("ViewOrder.jsp").forward(request,
					response);
		}

		else if (url.equals("/delete")) {
			String qty = request.getParameter("order_id");
			BigDecimal order_id = new BigDecimal(qty.replaceAll(",", ""));
			QueryImplementation qi = new QueryImplementation();
			qi.deleteOrder(order_id);
			request.getRequestDispatcher("PortfolioManager.jsp").forward(
					request, response);

		} else if (url.equals("/placeOrder")) {
			session = request.getSession();

			QueryImplementation o = new QueryImplementation();
			List<User> lst = o.fetchTraderDetails();
			request.setAttribute("TraderList", lst);

			ArrayList<Order> securitylist = new ArrayList<Order>();
			ResultSet resultSecurityList = o.fetchSymbol();

			try {
				while (resultSecurityList.next()) {
					Order order = new Order();
					order.setSymbol(resultSecurityList.getString("symbol"));
					securitylist.add(order);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			session.setAttribute("securityList", securitylist);

			request.getRequestDispatcher("/CreateOrder.jsp").forward(request,
					response);
		}
	}
}
