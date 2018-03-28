package com.sapient.entity;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.stereotype.Component;

@Component
@Entity
@NamedQueries({
	@NamedQuery(name="SecurityEntity.findAll" ,query="SELECT s from SecurityEntity s order by s.symbol asc"),
	@NamedQuery(name="SecurityEntity.find" ,query="SELECT s from SecurityEntity s where s.symbol=:symbol")
})

public class SecurityEntity {
	@Id
	private String symbol;
	@Column(nullable = false, unique = false)
	private String name;
	@Column(nullable = false, unique = false)
	private Double lastTradedPrice;
	@Column(nullable = false, unique = false)
	private Double priceSpread;
	@Column(nullable = false, unique = false)
	private Integer maxExecution;
	@Column(nullable = false, unique = false)
	private Integer maxInterval;
	@Column(nullable = false, unique = false)
	private Double probablePercentable;

	public SecurityEntity(String symbol, String name, Double lastTradedPrice,
			Double priceSpread, Integer maxExecution, Integer maxInterval,
			Double probablePercentable) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.lastTradedPrice = lastTradedPrice;
		this.priceSpread = priceSpread;
		this.maxExecution = maxExecution;
		this.maxInterval = maxInterval;
		this.probablePercentable = probablePercentable;
	}

	public SecurityEntity() {
		super();
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLastTradedPrice() {
		return lastTradedPrice;
	}

	public String getLastTradedPrice1() {
		DecimalFormat decimalFormat=new DecimalFormat("#.##");
		return decimalFormat.format(lastTradedPrice);
	}
	
	public void setLastTradedPrice(Double lastTradedPrice) {
		this.lastTradedPrice = lastTradedPrice;
	}

	public Double getPriceSpread() {
		return priceSpread;
	}

	public void setPriceSpread(Double priceSpread) {
		this.priceSpread = priceSpread;
	}

	public Integer getMaxExecution() {
		return maxExecution;
	}

	public void setMaxExecution(Integer maxExecution) {
		this.maxExecution = maxExecution;
	}

	public Integer getMaxInterval() {
		return maxInterval;
	}

	public void setMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
	}

	public Double getProbablePercentable() {
		return probablePercentable;
	}

	public void setProbablePercentable(Double probablePercentable) {
		this.probablePercentable = probablePercentable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lastTradedPrice == null) ? 0 : lastTradedPrice.hashCode());
		result = prime * result
				+ ((maxExecution == null) ? 0 : maxExecution.hashCode());
		result = prime * result
				+ ((maxInterval == null) ? 0 : maxInterval.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((priceSpread == null) ? 0 : priceSpread.hashCode());
		result = prime
				* result
				+ ((probablePercentable == null) ? 0 : probablePercentable
						.hashCode());
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
		SecurityEntity other = (SecurityEntity) obj;
		if (lastTradedPrice == null) {
			if (other.lastTradedPrice != null)
				return false;
		} else if (!lastTradedPrice.equals(other.lastTradedPrice))
			return false;
		if (maxExecution == null) {
			if (other.maxExecution != null)
				return false;
		} else if (!maxExecution.equals(other.maxExecution))
			return false;
		if (maxInterval == null) {
			if (other.maxInterval != null)
				return false;
		} else if (!maxInterval.equals(other.maxInterval))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priceSpread == null) {
			if (other.priceSpread != null)
				return false;
		} else if (!priceSpread.equals(other.priceSpread))
			return false;
		if (probablePercentable == null) {
			if (other.probablePercentable != null)
				return false;
		} else if (!probablePercentable.equals(other.probablePercentable))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SecurityEntity [symbol=" + symbol + ", name=" + name
				+ ", lastTradedPrice=" + lastTradedPrice + ", priceSpread="
				+ priceSpread + ", maxExecution=" + maxExecution
				+ ", maxInterval=" + maxInterval + ", probablePercentable="
				+ probablePercentable + "]";
	}

}
