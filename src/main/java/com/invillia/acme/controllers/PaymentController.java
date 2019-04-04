package com.invillia.acme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.dto.PaymentDTO;
import com.invillia.acme.exceptions.BusinessException;
import com.invillia.acme.services.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/payments")
	public PaymentDTO pay (@RequestBody PaymentDTO payment) throws BusinessException {
		 
		return paymentService.pay(payment);
	}
}
