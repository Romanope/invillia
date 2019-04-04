package com.invillia.acme.dto;

import java.util.Date;
import java.util.List;

import com.invillia.acme.model.enumeration.OrderStatus;

public class OrderDTO {
	
	private Long idStore;
		
	private String dateTime;

	private List<OrderAddressDTO> addresses;
	
	private Date dateTimeConfirmation;
	
	private OrderStatus status;
	
	private List<OrderItemDTO> items;

	public Long getIdStore() {
		return idStore;
	}

	public void setIdStore(Long idStore) {
		this.idStore = idStore;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public List<OrderAddressDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<OrderAddressDTO> addresses) {
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

	public List<OrderItemDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderItemDTO> items) {
		this.items = items;
	}
}
