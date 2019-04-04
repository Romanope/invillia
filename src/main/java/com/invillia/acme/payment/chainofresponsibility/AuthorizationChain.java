package com.invillia.acme.payment.chainofresponsibility;

import com.invillia.acme.exceptions.BusinessException;
import com.invillia.acme.model.Payment;

public abstract class AuthorizationChain {

	protected AuthorizationEnum authorization;
	
	protected AuthorizationChain next;
	
	public AuthorizationChain(AuthorizationEnum authorization) {
		next = null;
		this.authorization = authorization;
    }
	
	protected abstract void pay (Payment payment);
	
	public void setNext(AuthorizationChain authorization) {
        if (next == null) {
            next = authorization;
        } else {
            next.setNext(authorization);
        }
    }
	
	public void toPay (Payment payment) throws BusinessException {
	    if (isMakePayment(payment.getCardNumber())) {
	        pay(payment);
	    } else {
	        if (next == null) {
	            throw new BusinessException("No authorization found for the card number reported.");
	        }
	        next.toPay(payment);
	    }
	}
	
	private boolean isMakePayment (String cardNumber) {
		
		return cardNumber.substring(0, 6).equals(authorization.getIdCard());
	}
}
