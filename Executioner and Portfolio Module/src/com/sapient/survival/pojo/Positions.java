package com.sapient.survival.pojo;

import java.math.BigDecimal;

public class Positions {
	
	private BigDecimal positionsId;
    private BigDecimal portfolioId;
	private String symbol;
	private BigDecimal Quantity;
	private BigDecimal lastTradedPrice;
	public BigDecimal getPositionsId() {
		return positionsId;
	}
	public void setPositionsId(BigDecimal positionsId) {
		this.positionsId = positionsId;
	}
	public BigDecimal getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(BigDecimal portfolioId) {
		this.portfolioId = portfolioId;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public BigDecimal getQuantity() {
		return Quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		Quantity = quantity;
	}
	public BigDecimal getLastTradedPrice() {
		return lastTradedPrice;
	}
	public void setLastTradedPrice(BigDecimal lastTradedPrice) {
		this.lastTradedPrice = lastTradedPrice;
	}
	@Override
	public String toString() {
		return "Positions [positionsId=" + positionsId + ", portfolioId="
				+ portfolioId + ", symbol=" + symbol + ", Quantity=" + Quantity
				+ ", lastTradedPrice=" + lastTradedPrice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Quantity == null) ? 0 : Quantity.hashCode());
		result = prime * result
				+ ((lastTradedPrice == null) ? 0 : lastTradedPrice.hashCode());
		result = prime * result
				+ ((portfolioId == null) ? 0 : portfolioId.hashCode());
		result = prime * result
				+ ((positionsId == null) ? 0 : positionsId.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Positions other = (Positions) obj;
		if (Quantity == null) {
			if (other.Quantity != null)
				return false;
		} else if (!Quantity.equals(other.Quantity))
			return false;
		if (lastTradedPrice == null) {
			if (other.lastTradedPrice != null)
				return false;
		} else if (!lastTradedPrice.equals(other.lastTradedPrice))
			return false;
		if (portfolioId == null) {
			if (other.portfolioId != null)
				return false;
		} else if (!portfolioId.equals(other.portfolioId))
			return false;
		if (positionsId == null) {
			if (other.positionsId != null)
				return false;
		} else if (!positionsId.equals(other.positionsId))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}
 
	
	

}
