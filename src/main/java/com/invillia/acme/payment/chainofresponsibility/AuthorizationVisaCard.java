package com.invillia.acme.payment.chainofresponsibility;

import com.invillia.acme.model.Payment;

public class AuthorizationVisaCard extends AuthorizationChain {

	public AuthorizationVisaCard() {
		
		super(AuthorizationEnum.VISA);
	}

	@Override
	protected void pay (Payment payment) {
		
		System.out.println("Payment made by Visa.");
		// TODO
	}
}
