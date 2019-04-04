package com.invillia.acme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.invillia.acme.model.Store;

@Repository
public interface StoreDAO extends CrudRepository<Store, Long> {

	 @Query("select store from Store store where store.name like %:name% or store.id = :id")
	 public List<Store> searchStores(@Param("name") String name, @Param("id") Long id);
}
