package com.invillia.acme.payment.chainofresponsibility;

import com.invillia.acme.model.Payment;

public class AuthorizationMasterCard extends AuthorizationChain {

	public AuthorizationMasterCard() {
		
		super(AuthorizationEnum.MASTER_CARD);
	}

	@Override
	protected void pay (Payment payment) {
		
		System.out.println("Payment made by Mastercard.");
		// TODO
	}
}
