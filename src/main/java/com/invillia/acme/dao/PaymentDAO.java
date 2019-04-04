package com.invillia.acme.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invillia.acme.model.Payment;

@Repository
public interface PaymentDAO extends CrudRepository<Payment, Long> {

}
