package com.sapient.survival.pojo;

import java.math.BigDecimal;

public class Block {
	private BigDecimal blockId;
	private String side;
	private BigDecimal totalQuantity;
	private BigDecimal allocatedQuantity;
	private double avgPrice;
	private String status;
	private String blockSymbol;

	User u = new User();

	public String getBlockSymbol() {
		return blockSymbol;
	}

	public void setBlockSymbol(String blockSymbol) {
		this.blockSymbol = blockSymbol;
	}

	public BigDecimal getBlockId() {
		return blockId;
	}

	public void setBlockId(BigDecimal blockId) {
		this.blockId = blockId;
	}

	public BigDecimal getTraderId() {
		return u.getUserId();
	}

	public void setTraderId(BigDecimal traderId) {
		u.setUserId(traderId);
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

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 37;
		int result = 1;
		result = prime
				* result
				+ ((allocatedQuantity == null) ? 0 : allocatedQuantity
						.hashCode());
		long temp;
		temp = Double.doubleToLongBits(avgPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((blockId == null) ? 0 : blockId.hashCode());
		result = prime * result
				+ ((blockSymbol == null) ? 0 : blockSymbol.hashCode());
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((totalQuantity == null) ? 0 : totalQuantity.hashCode());
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
		Block other = (Block) obj;
		if (allocatedQuantity == null) {
			if (other.allocatedQuantity != null)
				return false;
		} else if (!allocatedQuantity.equals(other.allocatedQuantity))
			return false;
		if (Double.doubleToLongBits(avgPrice) != Double
				.doubleToLongBits(other.avgPrice))
			return false;
		if (blockId == null) {
			if (other.blockId != null)
				return false;
		} else if (!blockId.equals(other.blockId))
			return false;
		if (blockSymbol == null) {
			if (other.blockSymbol != null)
				return false;
		} else if (!blockSymbol.equals(other.blockSymbol))
			return false;
		if (side == null) {
			if (other.side != null)
				return false;
		} else if (!side.equals(other.side))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (totalQuantity == null) {
			if (other.totalQuantity != null)
				return false;
		} else if (!totalQuantity.equals(other.totalQuantity))
			return false;
		return true;
	}

}
