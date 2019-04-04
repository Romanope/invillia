package com.invillia.acme.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.invillia.acme.dao.PaymentDAO;
import com.invillia.acme.dto.PaymentDTO;
import com.invillia.acme.exceptions.BusinessException;
import com.invillia.acme.mappers.PaymentMapper;
import com.invillia.acme.model.Order;
import com.invillia.acme.model.Payment;
import com.invillia.acme.model.enumeration.PaymentStatus;
import com.invillia.acme.model.validators.PaymentValidator;
import com.invillia.acme.payment.chainofresponsibility.PaymentChainFactory;

@Service
public class PaymentService extends AbstractService<Payment, Long> {

	@Autowired
	private PaymentDAO dao;
	
	@Autowired
	private PaymentValidator validator;
	
	@Autowired
	private PaymentMapper paymentMapper;
	
	@Autowired
	private PaymentChainFactory paymentChain;
	
	@Autowired
	private OrderService orderService;
	
	@Transactional
	public PaymentDTO pay (PaymentDTO pay) throws BusinessException {
		
		validator.validate(pay);
		
		Payment newPayment = paymentMapper.toPayment(pay);
		
		paymentChain.getPaymentChain().toPay(newPayment);
		
		Order order = orderService.findById(pay.getStoreId(), pay.getDateTime());
		newPayment.setPayDate(new Date());
		newPayment.setOrder(order);
		newPayment.setStatus(PaymentStatus.APPROVED);
		
		// não tive tempo para implementar um algoritmo para simular a NAO autorização do PAGAMENTO
		
		super.save(newPayment);
		
		return paymentMapper.toPaymentDTO(newPayment);
	}
	
	@Override
	public CrudRepository<Payment, Long> getDao() {

		return this.dao;
	}
}
