package com.invillia.acme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.invillia.acme.model.OrderItem;
import com.invillia.acme.model.compositeids.OrderItemID;

@Repository
public interface OrderItemDAO extends CrudRepository<OrderItem, OrderItemID> {

	@Query("select item from OrderItem item where item.id.order.id.idStore = :idStore and  item.id.order.id.dateTime = :dateTime")
	 public List<OrderItem> listItemsOrderByOrder(@Param("idStore") Long idStore, @Param("dateTime") String dateTime);
}
