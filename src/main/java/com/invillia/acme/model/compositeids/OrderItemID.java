package com.invillia.acme.model.compositeids;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.invillia.acme.model.Order;

@Embeddable
public class OrderItemID implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY) 	 
	@JoinColumns({						
		@JoinColumn(name = "STR_ID", referencedColumnName = "STR_ID", updatable = false),
		@JoinColumn(name = "ORD_DATE_TIME", referencedColumnName = "ORD_DATE_TIME", updatable = false) })
	private Order order;
	
	@Column(name="PRO_ID", nullable = false, updatable = false)
	private Long idProduct;

	public OrderItemID(Order order, Long idProduct) {
		this.order = order;
		this.idProduct = idProduct;
	}

	public OrderItemID() {

	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
}
