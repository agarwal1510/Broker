package com.sapient.survival.pojo;

import java.math.BigDecimal;

import com.sapient.survival.pojo.User;

public class Portfolio {
	BigDecimal portfolioId;
	String name;

	User u = new User();
	
	public BigDecimal getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(BigDecimal portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUserId() {
		return u.getUserId();
	}

	public void setUserId(BigDecimal userId) {
		u.setUserId(userId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((portfolioId == null) ? 0 : portfolioId.hashCode());
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
		Portfolio other = (Portfolio) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (portfolioId == null) {
			if (other.portfolioId != null)
				return false;
		} else if (!portfolioId.equals(other.portfolioId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Portfolio [portfolioId=" + portfolioId + ", name=" + name + "]";
	}

}
