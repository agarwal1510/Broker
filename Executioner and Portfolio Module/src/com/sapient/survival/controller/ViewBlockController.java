package com.sapient.survival.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sapient.survival.pojo.Block;
import com.sapient.survival.pojo.ViewBlockModel;

public class ViewBlockController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewBlockController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Block> block = new ArrayList<>();
		response.setContentType("text/html");
		ViewBlockModel obj = new ViewBlockModel();
		try {
			block = obj.viewBlock();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		request.setAttribute("List", block);
		request.getRequestDispatcher("DisplayTable.jsp").forward(request,
				response);
	}
}
