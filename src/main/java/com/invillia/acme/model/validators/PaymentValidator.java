package com.invillia.acme.model.validators;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.invillia.acme.dto.PaymentDTO;
import com.invillia.acme.exceptions.BusinessException;
import com.invillia.acme.model.Order;
import com.invillia.acme.model.OrderItem;
import com.invillia.acme.services.OrderItemService;
import com.invillia.acme.services.OrderService;

@Component
public class PaymentValidator {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderItemService orderItemService;
	
	public void validate (PaymentDTO payment) throws BusinessException {
		
		if (payment == null) {
			throw new BusinessException("Payment is null");
		}
		
		validateOrder(payment);
		
		List<OrderItem> items = orderItemService.listItemsOrderByOrder(payment.getStoreId(), payment.getDateTime());
		
		validateItems(items);
		
		validateTotalPayment(payment, items);
	}

	private void validateItems(List<OrderItem> items) throws BusinessException {
		if (items == null || items.size() == 0) {
			throw new BusinessException("Items from order not found");
		}
	}

	private void validateTotalPayment(PaymentDTO payment, List<OrderItem> items) throws BusinessException {
		BigDecimal total = BigDecimal.ZERO;
		for (OrderItem item : items) {
			total = total.add(item.getQuantity().multiply(item.getUnitPrice()));
		}
		
		if (payment.getTotalPayment().compareTo(total) != 0) {
			throw new BusinessException("Total payment is different from sum of items");
		}
	}

	private void validateOrder(PaymentDTO payment) throws BusinessException {
		try {
			Order order = orderService.findById(payment.getStoreId(), payment.getDateTime());
			if (order == null) {
				throw new BusinessException("Order not found.");
			}
		} catch (NoSuchElementException e) {
			throw new BusinessException("Order not found.", e);
		}
	}
}
