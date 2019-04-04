package com.invillia.acme.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "O")
public class OrderAddress extends Address {

	@ManyToOne(fetch = FetchType.LAZY) 	 
	@JoinColumns({						
		@JoinColumn(name = "STR_ID", referencedColumnName = "STR_ID", updatable = false),
		@JoinColumn(name = "ORD_DATE_TIME", referencedColumnName = "ORD_DATE_TIME", updatable = false) })
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
