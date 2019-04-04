package com.invillia.acme.model.enumeration;

public enum PaymentStatus {

	APPROVED(1, "Approved"),
	DENIED(2, "Denied");
	
	private int id;
	
	private String name;
	
	PaymentStatus (int id, String name) {
		this.id = id;
		this.name= name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
