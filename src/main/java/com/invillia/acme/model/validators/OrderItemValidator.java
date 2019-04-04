package com.invillia.acme.model.validators;

import org.springframework.stereotype.Component;

import com.invillia.acme.exceptions.BusinessException;

@Component
public class OrderItemValidator {

	public void validate (Long storeId, String dateTime) throws BusinessException {
		if (storeId == null || storeId.compareTo(Long.valueOf(0)) <= 0) {
			throw new BusinessException("Store id is required.");
		}
		
		if (isBlank(dateTime)) {
			throw new BusinessException("Date Time is required.");
		}
	}
	
	private boolean isBlank (String value) {
		return value == null || value.length() == 0;
	}
}
