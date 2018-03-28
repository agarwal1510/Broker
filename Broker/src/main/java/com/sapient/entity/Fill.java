package com.sapient.entity;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;




@Entity
@NamedQueries({
	@NamedQuery(name="Fill.findAll" ,query="SELECT f from Fill f order by f.fillId desc")
})
@XmlRootElement(name = "Fill")
@Table(name="Fill")
public class Fill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="fillid")
	private BigInteger fillId;
	@Column(name="blockid")
	private BigInteger blockId;
	@Column(name="quantity")
	private BigInteger executedQuantity;
	@Column(name="execprice")
	private Double executedPrice;
	@Column(name="createddate")
	private Date date;

	public Fill(BigInteger blockId, BigInteger executedQuantity, Double executedPrice,Date date) {
		this.blockId = blockId;
		this.executedQuantity = executedQuantity;
		this.executedPrice = executedPrice;
		this.date=date;
	}

	public Fill(BigInteger fillId, BigInteger blockID, double price, Date date,
			BigInteger executedQuantity) {
		this.fillId = fillId;
		this.blockId = blockID;
		this.executedPrice = price;
		this.date = date;
		this.executedQuantity = executedQuantity;
		// TODO Auto-generated constructor stub
	}

	@XmlElement
	public Date getDate() {
		return date;
	}

	public Fill() {
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@XmlElement
	public BigInteger getFillId() {
		return fillId;
	}

	public void setFillId(BigInteger fillId) {
		this.fillId = fillId;
	}

	@XmlElement
	public BigInteger getBlockId() {
		return blockId;
	}

	public void setBlockId(BigInteger blockId) {
		this.blockId = blockId;
	}

	@XmlElement
	public BigInteger getExecutedQuantity() {
		return executedQuantity;
	}

	public void setExecutedQuantity(BigInteger executedQuantity) {
		this.executedQuantity = executedQuantity;
	}

	@XmlElement
	public String getExecutedPrice() {
		DecimalFormat decimalFormat=new DecimalFormat("#.##");
		return decimalFormat.format(executedPrice);
	}

	public void setExecutedPrice(Double executedPrice) {
		this.executedPrice = executedPrice;
	}

	@Override
	public String toString() {
		return "Fill [fillId=" + fillId + ", blockId=" + blockId
				+ ", quantity=" + executedQuantity + ", executedPrice=" + executedPrice
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blockId == null) ? 0 : blockId.hashCode());
		result = prime * result
				+ ((executedPrice == null) ? 0 : executedPrice.hashCode());
		result = prime * result + ((fillId == null) ? 0 : fillId.hashCode());
		result = prime * result
				+ ((executedQuantity == null) ? 0 : executedQuantity.hashCode());
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
		Fill other = (Fill) obj;
		if (blockId == null) {
			if (other.blockId != null)
				return false;
		} else if (!blockId.equals(other.blockId))
			return false;
		if (executedPrice == null) {
			if (other.executedPrice != null)
				return false;
		} else if (!executedPrice.equals(other.executedPrice))
			return false;
		if (fillId == null) {
			if (other.fillId != null)
				return false;
		} else if (!fillId.equals(other.fillId))
			return false;
		if (executedQuantity == null) {
			if (other.executedQuantity != null)
				return false;
		} else if (!executedQuantity.equals(other.executedQuantity))
			return false;
		return true;
	}

}
