package com.invillia.acme.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.invillia.acme.model.compositeids.OrderItemID;

@Entity
@Table(name="ORI_ITEM")
public class OrderItem implements Serializable {

	@Id
	private OrderItemID id;
	
	@Column(name="ORI_QUANTITY", nullable = false)
	private BigDecimal quantity;
	
	@Column(name="ORI_UNIT_PRICE", nullable = false)
	private BigDecimal unitPrice;

	public OrderItemID getId() {
		return id;
	}

	public void setId(OrderItemID id) {
		this.id = id;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
}
