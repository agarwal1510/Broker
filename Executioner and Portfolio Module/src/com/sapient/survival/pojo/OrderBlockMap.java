package com.sapient.survival.pojo;

import java.math.BigDecimal;

public class OrderBlockMap {

	Order o = new Order();
	Block b = new Block();

	public BigDecimal getBlockId() {
		return b.getBlockId();
	}

	public void setBlockId(BigDecimal blockId) {
		b.setBlockId(blockId);
	}

	public BigDecimal getOrderId() {
		return o.getOrderId();
	}

	public void setOrderId(BigDecimal orderId) {
		o.setOrderId(orderId);
	}

}
