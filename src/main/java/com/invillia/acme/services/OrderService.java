package com.invillia.acme.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invillia.acme.dao.OrderDAO;
import com.invillia.acme.dto.OrderDTO;
import com.invillia.acme.exceptions.BusinessException;
import com.invillia.acme.mappers.OrderItemMapper;
import com.invillia.acme.mappers.OrderMapper;
import com.invillia.acme.model.Order;
import com.invillia.acme.model.OrderAddress;
import com.invillia.acme.model.OrderItem;
import com.invillia.acme.model.compositeids.OrderID;
import com.invillia.acme.model.enumeration.OrderStatus;
import com.invillia.acme.model.validators.OrderValidator;
import com.invillia.acme.util.Util;

@Service
public class OrderService extends AbstractService<Order, OrderID> {

	@Autowired
	private Util util;
	
	@Autowired
	private OrderDAO dao;

	@Autowired
	private OrderAddressService orderAddressService;
	
	@Autowired
	private OrderItemService itemService;
	
	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderItemMapper itemMapper;
	
	@Autowired
	private OrderValidator validator;
	
	@Transactional
	public OrderDTO insert (OrderDTO orderDTO) throws BusinessException {
		
		validator.validate(orderDTO);
		
		Order newOrder = orderMapper.toOrder(orderDTO);
		
		insert(newOrder);
		
		saveAddresses(newOrder);
		
		newOrder.setItems(itemMapper.toOrdemItems(orderDTO.getItems()));
		
		saveItems(newOrder);
		
		return orderMapper.toOrderDTO(newOrder);
	}
	
	private void saveItems (Order order) throws BusinessException {
		
		for (OrderItem item : order.getItems()) {
			item.getId().setOrder(order);
			itemService.save(item);
		}
	}

	/**
	 * This method create one new order record
	 * validating order data
	 * @param order
	 * @return
	 * @throws BusinessException
	 */
	@Transactional
	public Order insert (Order order) throws BusinessException {
		
		order.setId(createID(order));
		order.setStatus(OrderStatus.WAITING_CONFIRMATION);
		
		super.save(order);
		
		return order;
	}
	
	@Transactional(readOnly = true)
	public List<OrderDTO> listAllDTO () {

		Iterator<Order> itOrders = getDao().findAll().iterator();
		List<OrderDTO> result = new ArrayList<>();
		while (itOrders.hasNext()) {
			Order currentOrder = itOrders.next();
			result.add(orderMapper.toOrderDTO(currentOrder));
		}
		
		return result;
	}

	private void saveAddresses(Order order) throws BusinessException {
		for (OrderAddress address : order.getAddresses()) {
			address.setOrder(order);
			orderAddressService.save(address);
			address.setOrder(null);
		}
	}

	private OrderID createID(Order order) throws BusinessException {
		OrderID id = new OrderID();
		id.setDateTime(util.format(new Date()));
		id.setIdStore(order.getId().getIdStore());
		return id;
	}
	
	@Transactional(readOnly = true)
	public Order findById(Long storeId, String dateTime) {

		return dao.findByIdCustom(storeId, dateTime);
	}

	@Transactional(readOnly = true)
	public OrderDTO findByIdDTO(Long storeId, String dateTime) {
		
		return orderMapper.toOrderDTO(dao.findByIdCustom(storeId, dateTime));
	}
	
	@Override
	public CrudRepository<Order, OrderID> getDao() {
		
		return this.dao;
	}
}
