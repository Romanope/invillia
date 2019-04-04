package com.invillia.acme.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invillia.acme.model.OrderAddress;

@Repository
public interface OrderAddressDAO extends CrudRepository<OrderAddress, Long> {
	
}
