package com.sapient.survival.pojo;

import java.math.BigDecimal;
import java.security.Timestamp;


public class Order {
	private BigDecimal orderId;
	private String symbol;
	private BigDecimal portfolioId;
	private String side;
	private BigDecimal totalQuantity;
	private BigDecimal allocatedQuantity;
	private String orderType;
	private double stopPrice;
	private double limitPrice;
	private double executedPrice;
    private BigDecimal traderId;
    private String status;
    private Timestamp creationTime;
    private String trader;
    private String portfolioManagerName;
    private String portfolioName;
    
  
    
	
    public String getPortfolioManagerName() {
		return portfolioManagerName;
	}

	public void setPortfolioManagerName(String portfolioManagerName) {
		this.portfolioManagerName = portfolioManagerName;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public double getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(double stopPrice) {
		this.stopPrice = stopPrice;
	}

	public double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(double limitPrice) {
		this.limitPrice = limitPrice;
	}

	public BigDecimal getOrderId() {
		return orderId;
	}


	public void setOrderId(BigDecimal orderId) {
		this.orderId = orderId;
	}


	public String getSymbol() {
		return symbol;
	}
	public String getTrader() {
		return trader;
	}
	public void setTrader(String trader) {
		this.trader = trader;
	}

	


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}



	public BigDecimal getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(BigDecimal portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getSide() {
		return side;
	}


	public void setSide(String side) {
		this.side = side;
	}


	public BigDecimal getTotalQuantity() {
		return totalQuantity;
	}


	public void setTotalQuantity(BigDecimal totalQuantity) {
		this.totalQuantity = totalQuantity;
	}


	public BigDecimal getAllocatedQuantity() {
		return allocatedQuantity;
	}


	public void setAllocatedQuantity(BigDecimal allocatedQuantity) {
		this.allocatedQuantity = allocatedQuantity;
	}


	public String getOrderType() {
		return orderType;
	}


	public void setOrderType(String ordertype) {
		this.orderType = ordertype;
	}


	


	public double getExecutedPrice() {
		return executedPrice;
	}


	public void setExecutedPrice(double executedPrice) {
		this.executedPrice = executedPrice;
	}


	


	public BigDecimal getTraderId() {
		return traderId;
	}

	public void setTraderId(BigDecimal traderId) {
		this.traderId = traderId;
	}

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Timestamp getCreationTime() {
		return creationTime;
	}


	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}



	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", symbol=" + symbol
				+ ", portfolioId=" + portfolioId + ", side=" + side
				+ ", totalQuantity=" + totalQuantity + ", allocatedQuantity="
				+ allocatedQuantity + ", orderType=" + orderType
				+ ", stopPrice=" + stopPrice + ", limitPrice=" + limitPrice
				+ ", executedPrice=" + executedPrice + ", traderId=" + traderId
				+ ", status=" + status + ", creationTime=" + creationTime
				+ ", trader=" + trader + "]";
	}







	
	
	
	
    
       
    
}
