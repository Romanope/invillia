package com.invillia.acme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.invillia.acme.dao.OrderAddressDAO;
import com.invillia.acme.model.OrderAddress;

@Service
public class OrderAddressService extends AbstractService<OrderAddress, Long> {

	@Autowired
	private OrderAddressDAO dao;
	
	@Override
	public CrudRepository<OrderAddress, Long> getDao() {
		
		return this.dao;
	}
}
