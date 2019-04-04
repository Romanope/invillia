package com.invillia.acme.dto;

import java.math.BigDecimal;

public class OrderItemDTO {

	private Long idStore;
	
	private String dateTime;
	
	private Long idProduct;
	
	private BigDecimal quantity;
	
	private BigDecimal unitPrice;

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

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
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
