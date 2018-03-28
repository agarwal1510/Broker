package com.sapient.survival.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sapient.survival.pojo.Portfolio;
import com.sapient.util.ConnectionUtil;

import java.math.BigDecimal;
public class PortfolioDao extends ConnectionUtil implements Query {
	public List<Portfolio> getPortfolio(BigDecimal userId) {
		List<Portfolio> portfolios = new ArrayList<Portfolio>();
		Connection conn = ConnectionUtil.getConnection();
		Portfolio tempPortfolio =new Portfolio();
		try {
			PreparedStatement ps = conn
					.prepareStatement(fetchPortfolioForTrader);
			ps.setBigDecimal(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tempPortfolio.setPortfolioId(rs.getBigDecimal("portfolio_id"));
				tempPortfolio.setName(rs.getString("name"));
				tempPortfolio.setUserId(rs.getBigDecimal("user_id"));
				portfolios.add(tempPortfolio);
			}
			  conn.close();
		} catch (Exception e) {

		}
		return portfolios;
	}
}
