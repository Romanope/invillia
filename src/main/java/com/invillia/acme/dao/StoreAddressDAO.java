package com.invillia.acme.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invillia.acme.model.StoreAddress;

@Repository
public interface StoreAddressDAO extends CrudRepository<StoreAddress, Long> {

}
