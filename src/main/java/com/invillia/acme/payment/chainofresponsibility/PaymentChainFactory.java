package com.invillia.acme.payment.chainofresponsibility;

import org.springframework.stereotype.Component;

@Component
public class PaymentChainFactory {

	private AuthorizationChain paymentChain;
	
	private AuthorizationChain createPaymentChain () {
		
		AuthorizationChain chain = new AuthorizationHiperCard();
		chain.setNext(new AuthorizationMasterCard());
		chain.setNext(new AuthorizationVisaCard());
		
		return chain;
	}
	
	public AuthorizationChain getPaymentChain () {
		
		if (paymentChain == null) {
			paymentChain = createPaymentChain();
		}
		
		return paymentChain;
	}
}
