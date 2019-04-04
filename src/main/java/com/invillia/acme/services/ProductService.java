package com.invillia.acme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.invillia.acme.dao.ProductDAO;
import com.invillia.acme.model.Product;

@Service
public class ProductService extends AbstractService<Product, Long>{

	@Autowired
	private ProductDAO dao;
	
	@Override
	public CrudRepository<Product, Long> getDao() {

		return this.dao;
	}
}
