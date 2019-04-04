package com.invillia.acme.payment.chainofresponsibility;

import com.invillia.acme.model.Payment;

public class AuthorizationHiperCard extends AuthorizationChain {

	public AuthorizationHiperCard() {
		
		super(AuthorizationEnum.HIPERCARD);
	}

	@Override
	protected void pay (Payment payment) {
		
		System.out.println("Payment made by Hipercard.");
		// TODO
	}
}
