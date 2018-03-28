package com.sapient.survival.dao;

import java.sql.*;
import java.util.*;

import com.sapient.survival.pojo.Positions;
import com.sapient.util.ConnectionUtil;

import java.math.BigDecimal;

public class PositionDao extends ConnectionUtil implements Query {

	public List<Positions> getPositionList(BigDecimal portfolioId) {
		List<Positions> position = new ArrayList<Positions>();
		Connection conn = ConnectionUtil.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement(fetchPositionForPortfolio);
			ps.setBigDecimal(1, portfolioId);
			ResultSet rs = ps.executeQuery();
			Positions tempPosition = new Positions();
			while (rs.next()) {
				tempPosition.setPortfolioId(rs.getBigDecimal("portfolio_id"));
				tempPosition.setPositionsId(rs.getBigDecimal("position_id"));
				tempPosition.setQuantity(rs.getBigDecimal("quantity"));
				tempPosition.setSymbol(rs.getString("symbol"));
				tempPosition.setLastTradedPrice(rs
						.getBigDecimal("last_traded_price"));
				position.add(tempPosition);
			}
			conn.close();
		} catch (Exception e) {

		}

		return position;

	}

	public Positions getPosition(BigDecimal position_id) {
		Connection conn = getConnection();
		Positions tempPosition = new Positions();
		try {
			PreparedStatement ps = conn
					.prepareStatement(fetchPositionForPositionId);
			ps.setBigDecimal(1, position_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				tempPosition.setPortfolioId(rs.getBigDecimal("portfolio_id"));
				tempPosition.setPositionsId(rs.getBigDecimal("position_id"));
				tempPosition.setQuantity(rs.getBigDecimal("quantity"));
				tempPosition.setSymbol(rs.getString("symbol"));
				tempPosition.setLastTradedPrice(rs
						.getBigDecimal("last_traded_price"));
			}
			conn.close();
		} catch (Exception e) {

		}
		return tempPosition;
	}

	public Positions getPosition(BigDecimal portfolioId,
			BigDecimal quantity) {
		Connection conn = getConnection();
		Positions tempPosition = new Positions();
		try {
			PreparedStatement ps = conn
					.prepareStatement(fetchPositionForPortfolioIdnSymbol);
			ps.setBigDecimal(1, portfolioId);
			ps.setBigDecimal(2, quantity);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				tempPosition.setPortfolioId(rs.getBigDecimal("portfolio_id"));
				tempPosition.setPositionsId(rs.getBigDecimal("position_id"));
				tempPosition.setQuantity(rs.getBigDecimal("quantity"));
				tempPosition.setSymbol(rs.getString("symbol"));
				tempPosition.setLastTradedPrice(rs
						.getBigDecimal("last_traded_price"));
			}
			conn.close();
		} catch (Exception e) {

		}
		return tempPosition;
	}

	public Boolean updatePositionQuantity(BigDecimal positionId,
			BigDecimal quantity) {
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement(updatePositionQuantity);
			ps.setBigDecimal(1, quantity);
			ps.setBigDecimal(2, positionId);

			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Boolean updatePositionQuantity(BigDecimal portfolioId,
			String symbol, BigDecimal quantity) {

		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement(updatePositionQuantityBysymbolandPortfolio);
			ps.setBigDecimal(1, quantity);
			ps.setBigDecimal(2, portfolioId);
			ps.setString(3, symbol);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public Boolean deletePosition(BigDecimal positionId)
	{
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(deleteEmptyPosition);
			ps.setBigDecimal(1, positionId);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}