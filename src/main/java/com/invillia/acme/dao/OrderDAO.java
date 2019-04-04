package com.invillia.acme.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.invillia.acme.model.Order;
import com.invillia.acme.model.compositeids.OrderID;

@Repository
public interface OrderDAO extends CrudRepository<Order, OrderID> {

	 @Query("select order from Order order where order.id.idStore = :idStore and  order.id.dateTime = :dateTime")
	 public Order findByIdCustom(@Param("idStore") Long idStore, @Param("dateTime") String dateTime);
}
