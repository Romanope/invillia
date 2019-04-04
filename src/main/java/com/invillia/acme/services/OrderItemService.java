package com.invillia.acme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invillia.acme.dao.OrderItemDAO;
import com.invillia.acme.dto.OrderItemDTO;
import com.invillia.acme.exceptions.BusinessException;
import com.invillia.acme.mappers.OrderItemMapper;
import com.invillia.acme.model.OrderItem;
import com.invillia.acme.model.compositeids.OrderItemID;
import com.invillia.acme.model.validators.OrderItemValidator;

@Service
public class OrderItemService extends AbstractService<OrderItem, OrderItemID> {

	@Autowired
	private OrderItemDAO dao;
	
	@Autowired
	private OrderItemMapper itemMapper;
	
	@Autowired
	private OrderItemValidator validator;
	
	@Transactional(readOnly = true)
	public List<OrderItem> listItemsOrderByOrder (Long storeId, String dateTime) throws BusinessException {
		
		validator.validate(storeId, dateTime);
		
		return dao.listItemsOrderByOrder(storeId, dateTime);
	}

	@Transactional(readOnly = true)
	public List<OrderItemDTO> listItemsOrderByOrderDTO (Long storeId, String dateTime) throws BusinessException {
		
		validator.validate(storeId, dateTime);
		
		List<OrderItem> items = dao.listItemsOrderByOrder(storeId, dateTime);

		return itemMapper.toOrdemItemsDTO(items);
	}
	
	@Override
	public CrudRepository<OrderItem, OrderItemID> getDao() {

		return this.dao;
	}
}
