package com.sapient.entity;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "block_broker")
@XmlRootElement(name = "block")
@NamedQueries(@NamedQuery(name="Block.selectNotExecuted" ,query="select b from Block b where b.executedQuantity=:executedQuantity"))
public class Block {
	@Id
	@Column(name = "bid")
	private BigInteger blockId;
	@Column(name = "side")
	private String side;
	@Column(name = "symbol")
	private String symbol;
	@Column(name = "status")
	private String status;
	@Column(name = "limitprice")
	private Double limitPrice;
	@Column(name = "stopprice")
	private Double stopPrice;
	@Column(name = "totalquantity")
	private BigInteger totalQuantity;
	@Column(name = "executedquantity")
	private BigInteger executedQuantity;
	@Column(name = "openquantity")
	private BigInteger openQuantity;
	@Column(name = "type")
	private String type;
	@XmlElement
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@XmlElement
	public BigInteger getBlockId() {
		return blockId;
	}

	public void setBlockId(BigInteger blockId) {
		this.blockId = blockId;
	}
	@XmlElement
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	@XmlElement
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	@XmlElement
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@XmlElement
	public Double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(Double limitPrice) {
		this.limitPrice = limitPrice;
	}
	@XmlElement
	public Double getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(Double stopPrice) {
		this.stopPrice = stopPrice;
	}
	@XmlElement
	public BigInteger getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(BigInteger totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	@XmlElement
	public BigInteger getExecutedQuantity() {
		return executedQuantity;
	}

	public void setExecutedQuantity(BigInteger executedQuantity) {
		this.executedQuantity = executedQuantity;
	}
	@XmlElement
	public BigInteger getOpenQuantity() {
		return openQuantity;
	}

	public void setOpenQuantity(BigInteger openQuantity) {
		this.openQuantity = openQuantity;
	}

	@Override
	public String toString() {
		return "Block [blockId=" + blockId + ", side=" + side + ", symbol="
				+ symbol + ", status=" + status + ", limitPrice=" + limitPrice
				+ ", stopPrice=" + stopPrice + ", totalQuantity="
				+ totalQuantity + ", executedQuantity=" + executedQuantity
				+ ", openQuantity=" + openQuantity + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blockId == null) ? 0 : blockId.hashCode());
		result = prime
				* result
				+ ((executedQuantity == null) ? 0 : executedQuantity.hashCode());
		result = prime * result
				+ ((limitPrice == null) ? 0 : limitPrice.hashCode());
		result = prime * result
				+ ((openQuantity == null) ? 0 : openQuantity.hashCode());
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((stopPrice == null) ? 0 : stopPrice.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result
				+ ((totalQuantity == null) ? 0 : totalQuantity.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (blockId == null) {
			if (other.blockId != null)
				return false;
		} else if (!blockId.equals(other.blockId))
			return false;
		if (executedQuantity == null) {
			if (other.executedQuantity != null)
				return false;
		} else if (!executedQuantity.equals(other.executedQuantity))
			return false;
		if (limitPrice == null) {
			if (other.limitPrice != null)
				return false;
		} else if (!limitPrice.equals(other.limitPrice))
			return false;
		if (openQuantity == null) {
			if (other.openQuantity != null)
				return false;
		} else if (!openQuantity.equals(other.openQuantity))
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
		if (stopPrice == null) {
			if (other.stopPrice != null)
				return false;
		} else if (!stopPrice.equals(other.stopPrice))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (totalQuantity == null) {
			if (other.totalQuantity != null)
				return false;
		} else if (!totalQuantity.equals(other.totalQuantity))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public Block() {
		
		
	}

}
