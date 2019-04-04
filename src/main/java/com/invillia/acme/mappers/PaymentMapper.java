package com.invillia.acme.mappers;

import org.springframework.stereotype.Component;

import com.invillia.acme.dto.PaymentDTO;
import com.invillia.acme.model.Payment;

@Component
public class PaymentMapper {

	public Payment toPayment (PaymentDTO dto) {
		
		if (dto == null) {
			return null;
		}
		
		Payment pay = new Payment();
		
		pay.setCardNumber(dto.getCardNumber());
		pay.setId(dto.getId());
		pay.setPayDate(dto.getPayDate());
		pay.setStatus(dto.getStatus());
		pay.setTotalPayment(dto.getTotalPayment());
		
		return pay;
	}

	public PaymentDTO toPaymentDTO (Payment pay) {
		
		if (pay == null) {
			return null;
		}
		
		PaymentDTO dto = new PaymentDTO();
		
		dto.setCardNumber(pay.getCardNumber());
		dto.setId(pay.getId());
		dto.setPayDate(pay.getPayDate());
		dto.setStatus(pay.getStatus());
		dto.setDateTime(pay.getOrder().getId().getDateTime());
		dto.setStoreId(pay.getOrder().getId().getIdStore());
		dto.setTotalPayment(pay.getTotalPayment());
		
		return dto;
	}
}
