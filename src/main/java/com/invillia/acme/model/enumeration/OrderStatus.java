package com.invillia.acme.model.enumeration;

public enum OrderStatus {

	CONFIRMED(1, "Confirmed"),
	CANCELED(2, "Canceled"),
	WAITING_CONFIRMATION(3, "Waiting confirmation"),
	PAYMENT_DENIED(4, "Payment denied");
	
	private int code;
	private String name;

	OrderStatus (int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
