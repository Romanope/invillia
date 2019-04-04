package com.invillia.acme.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.invillia.acme.dto.OrderDTO;
import com.invillia.acme.model.Order;
import com.invillia.acme.model.compositeids.OrderID;

@Component
public class OrderMapper {

	@Autowired
	private AddressMapper addressMapper;
	
	@Autowired
	private OrderItemMapper orderItemMapper;
	
	public Order toOrder (OrderDTO orderDTO) {
		
		if (orderDTO == null) {
			return null;
		}
		
		Order order = new Order();
		order.setAddresses(addressMapper.toOrderAddress(orderDTO.getAddresses()));
		order.setDateTimeConfirmation(orderDTO.getDateTimeConfirmation());
		order.setStatus(orderDTO.getStatus());
		
		OrderID id = new OrderID();
		id.setDateTime(orderDTO.getDateTime());
		id.setIdStore(orderDTO.getIdStore());
		order.setId(id);
		
		
		return order;
	}

	public OrderDTO toOrderDTO (Order order) {
		
		if (order == null) {
			return null;
		}
		
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setAddresses(addressMapper.toOrderAddressDTO(order.getAddresses()));
		orderDTO.setItems(orderItemMapper.toOrdemItemsDTO(order.getItems()));
		orderDTO.setDateTimeConfirmation(order.getDateTimeConfirmation());
		orderDTO.setStatus(order.getStatus());
		orderDTO.setDateTime(order.getId().getDateTime());
		orderDTO.setIdStore(order.getId().getIdStore());
		
		return orderDTO;
	}
}
