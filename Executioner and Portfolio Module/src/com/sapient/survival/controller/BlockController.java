package com.sapient.survival.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.survival.dao.BlockDao;
import com.sapient.survival.exceptions.InvalidBlockException;
import com.sapient.survival.pojo.Block;

public class BlockController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BlockController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BlockDao obj = new BlockDao();
		List<Block> list = null;
		try {
			list = obj.getBlocks();
		} catch (InvalidBlockException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("blockList", list);
		RequestDispatcher rd = request.getRequestDispatcher("ViewBlocks.jsp");
		rd.forward(request, response);
	}

}
