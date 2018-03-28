package com.sapient.survival.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.util.ConnectionUtil;

public class SendBlockForExecutionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SendBlockForExecutionController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
		try {
			conn = ConnectionUtil.getConnection();
			String sql;
			String blockid[] = request.getParameterValues("c1");
			for (int i = 0; i < blockid.length; i++) {
				BigDecimal bid = new BigDecimal(blockid[i].replaceAll(",", ""));
				sql = "update blocks set status='Sent For Execution' where Block_id=?";
				PreparedStatement prepStmt = conn.prepareStatement(sql);
				prepStmt.setBigDecimal(1, bid);
				prepStmt.executeUpdate();
			}

		} catch (SQLException se) {

			se.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("/ViewBlockController1");
		rd.forward(request, response);
	}
}
