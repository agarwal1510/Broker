package com.sapient.survival.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sapient.survival.dao.*;
import com.sapient.survival.pojo.*;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String accesstype = request.getParameter("accesstype");
		Userdao fetch = new Userdao();
		try {
			User fetchedUser = fetch.FetchUser(username);
			String fetchedPassword = fetchedUser.getPassword();
			String fetchedUsername = fetchedUser.getUsername();
			BigDecimal fetchedUserID = fetchedUser.getUserId();
			String fetchedName = fetchedUser.getName();
			if ((fetchedPassword.equals(password))
					&& (fetchedUsername.equals(username))) {

				System.out.println("password is correct");
				String role = fetchedUser.getRole();
				if ((role.equals("portfoliomanager")
						&& (accesstype.equals("PortfolioManager")) || (role
						.equals("both"))
						&& accesstype.equals("PortfolioManager"))) {
					
					//TODO change here for multiple portfolio
					PortfolioDao objPortfolio = new PortfolioDao();
					List<Portfolio> listPortfolio = objPortfolio.getPortfolio(fetchedUserID);
					Portfolio portfolio = listPortfolio.get(0);
					
					BigDecimal portfolioId = portfolio.getPortfolioId();
					
					HttpSession session = request.getSession();
					boolean loggedin = true;
					session.setAttribute("username", username);
					session.setAttribute("loggedIn", loggedin);
					session.setAttribute("role", role);
					session.setAttribute("userId", fetchedUserID);
					session.setAttribute("portfolioId", portfolioId);
					request.setAttribute("welcomeManager", "Welcome "
							+ fetchedName);
					
					RequestDispatcher rd = request
							.getRequestDispatcher("PortfolioManager.jsp");

					rd.forward(request, response);

				} else if ((role.equals("trader")
						&& (accesstype.equals("Trader")) || (role
						.equals("both")) && accesstype.equals("Trader"))) {
					HttpSession session = request.getSession();
					boolean loggedin = true;
					session.setAttribute("username", username);
					session.setAttribute("loggedIn", loggedin);
					session.setAttribute("role", role);
					session.setAttribute("userId", fetchedUserID);

					request.setAttribute("welcomeTrader", "Welcome "
							+ fetchedName);
					RequestDispatcher rd = request
							.getRequestDispatcher("/viewOrders");

					rd.forward(request, response);

				} else {
					String msg = "Invalid Access Type!!!";
					request.setAttribute("msg", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);

				}

			}

			else {
				String msg = "Invalid credentials!!!";
				request.setAttribute("msg", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
// TODO Auto-generated method stub

