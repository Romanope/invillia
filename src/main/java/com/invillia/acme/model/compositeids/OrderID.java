package com.invillia.acme.model.compositeids;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderID implements Serializable {

	@Column(name = "STR_ID", nullable = false, updatable=false, insertable = true)
	private Long idStore;
	
	@Column(name = "ORD_DATE_TIME", nullable = false, updatable=false, insertable = true)
	private String dateTime;

	public OrderID(Long idStore, String id) {
		this.idStore = idStore;
		this.dateTime = id;
	}

	public OrderID () {

	}

	public Long getIdStore() {
		return idStore;
	}

	public void setIdStore(Long idStore) {
		this.idStore = idStore;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String id) {
		this.dateTime = id;
	}
}
