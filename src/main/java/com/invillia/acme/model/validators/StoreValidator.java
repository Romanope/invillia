package com.invillia.acme.model.validators;

import org.springframework.stereotype.Component;

import com.invillia.acme.exceptions.BusinessException;
import com.invillia.acme.model.Store;

@Component
public class StoreValidator {

	public void validate (Store store) throws BusinessException {
		
		if (store == null) {
			throw new BusinessException("Store is null");
		}
		
		if (isBlank(store.getName())) {
			throw new BusinessException("Store name is required.");
		}

		if (store.getAddresses() == null || store.getAddresses().isEmpty()) {
			throw new BusinessException("Store Address is required.");
		}
	}
	
	private boolean isBlank (String value) {
		
		return value == null || value.length() == 0;
	}
}
