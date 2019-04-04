package com.invillia.acme.model.validators;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.invillia.acme.dto.OrderDTO;
import com.invillia.acme.exceptions.BusinessException;
import com.invillia.acme.model.Store;
import com.invillia.acme.services.StoreService;

@Component
public class OrderValidator {

	@Autowired
	private StoreService storeService;
	
	public void validate (OrderDTO order) throws BusinessException {
		
		if (order == null) {
			throw new BusinessException("Order is null");
		}
		
		if (order.getAddresses() == null || order.getAddresses().isEmpty()) {
			throw new BusinessException("Address is required");
		}

		if (order.getItems() == null || order.getItems().isEmpty()) {
			throw new BusinessException("Items is required");
		}
		
		try {
			Store orderStore = storeService.findById(order.getIdStore());
			if (orderStore == null) {
				throw new BusinessException("Invalid store ID");
			}
		} catch (NoSuchElementException e) {
			throw new BusinessException("Invalid store ID", e);
		}
		
		// More validations here
	}
}
