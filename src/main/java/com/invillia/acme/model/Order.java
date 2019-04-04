package com.invillia.acme.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.invillia.acme.model.compositeids.OrderID;
import com.invillia.acme.model.enumeration.OrderStatus;

@SuppressWarnings("serial")
@Entity
@Table(name="ORD_ORDER")
public class Order implements Serializable {

	@Id
	private OrderID id;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
	private List<OrderAddress> addresses;
	
	@Column(name="ORD_DT_CONFIRMATION", nullable = true)
	private Date dateTimeConfirmation;
	
	@Enumerated(EnumType.ORDINAL)
    @Column(name="ORD_STATUS", length = 1, nullable = false)
	private OrderStatus status;
	
	@OneToMany(mappedBy = "id.order", fetch = FetchType.LAZY)
	private List<OrderItem> items;

	public OrderID getId() {
		return id;
	}

	public void setId(OrderID id) {
		this.id = id;
	}

	public List<OrderAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<OrderAddress> addresses) {
		this.addresses = addresses;
	}

	public Date getDateTimeConfirmation() {
		return dateTimeConfirmation;
	}

	public void setDateTimeConfirmation(Date dateTimeConfirmation) {
		this.dateTimeConfirmation = dateTimeConfirmation;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
}
