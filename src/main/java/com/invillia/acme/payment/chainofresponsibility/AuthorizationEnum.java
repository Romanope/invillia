package com.invillia.acme.payment.chainofresponsibility;

public enum AuthorizationEnum {

	HIPERCARD(1, "636261"),
	VISA(2, "556341"),
	MASTER_CARD(3, "415687");
	
	private int id;
	private String idCard;
	
	AuthorizationEnum (int id, String idCard) {
		this.id = id;
		this.idCard = idCard;
	}

	public int getId() {
		return id;
	}

	public String getIdCard() {
		return idCard;
	}
}
