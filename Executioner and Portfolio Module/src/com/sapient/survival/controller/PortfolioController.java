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

import com.sapient.survival.dao.PortfolioDao;
import com.sapient.survival.dao.PositionDao;
import com.sapient.survival.pojo.Portfolio;
import com.sapient.survival.pojo.Positions;


public class PortfolioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PortfolioController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PortfolioDao objPortfolio = new PortfolioDao();
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("userId");
		BigDecimal userId = new BigDecimal(user.replaceAll(",","" ));
		List<Portfolio> listPortfolio = objPortfolio.getPortfolio(userId);
		request.setAttribute("portfolio",listPortfolio);
		PositionDao objPosition = new PositionDao();
		Portfolio portfolio = listPortfolio.get(0);
		List<Positions> listPosition = objPosition.getPositionList(portfolio.getPortfolioId());
		request.setAttribute("position", listPosition);
		RequestDispatcher rd = request.getRequestDispatcher("");//Insert dispatcher address
		rd.forward(request,response);
	}

}
