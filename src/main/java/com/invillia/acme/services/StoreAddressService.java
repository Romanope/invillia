package com.invillia.acme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.invillia.acme.dao.StoreAddressDAO;
import com.invillia.acme.model.StoreAddress;

@Component
public class StoreAddressService extends AbstractService<StoreAddress, Long> {

	@Autowired
	private StoreAddressDAO dao;
	
	public StoreAddressService() {
		super();
	}

	@Override
	public CrudRepository<StoreAddress, Long> getDao() {
		
		return this.dao;
	}
}
