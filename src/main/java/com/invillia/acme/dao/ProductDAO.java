package com.invillia.acme.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invillia.acme.model.Product;

@Repository
public interface ProductDAO extends CrudRepository<Product, Long> {

}
