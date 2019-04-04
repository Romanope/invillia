package com.invillia.acme.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.invillia.acme.dto.OrderItemDTO;
import com.invillia.acme.model.OrderItem;
import com.invillia.acme.model.compositeids.OrderItemID;

@Component
public class OrderItemMapper {

	public List<OrderItem> toOrdemItems (List<OrderItemDTO> dtos) {
		
		List<OrderItem> result = new ArrayList<>();
		if (dtos != null) {
			for (OrderItemDTO itemDTO : dtos) {
				result.add(toOrderItem(itemDTO));
			}
		}
		
		return result;
	}
	
	public OrderItem toOrderItem (OrderItemDTO dto) {
		
		OrderItem newOrderItem = new OrderItem();
		
		if (dto == null) {
			return null;
		}
		
		OrderItemID id = new OrderItemID(null, dto.getIdProduct());
		
		newOrderItem.setId(id);
		newOrderItem.setQuantity(dto.getQuantity());
		newOrderItem.setUnitPrice(dto.getUnitPrice());
		
		return newOrderItem;
	}
	
	public List<OrderItemDTO> toOrdemItemsDTO (List<OrderItem> items) {
		
		List<OrderItemDTO> result = new ArrayList<>();
		if (items != null) {
			for (OrderItem item : items) {
				result.add(toOrderItemDTO(item));
			}
		}
		
		return result;
	}
	
	public OrderItemDTO toOrderItemDTO (OrderItem item) {
		
		OrderItemDTO orderItemDTO = new OrderItemDTO();
		
		if (item == null) {
			return null;
		}
		
		orderItemDTO.setDateTime(item.getId().getOrder().getId().getDateTime());
		orderItemDTO.setIdStore(item.getId().getOrder().getId().getIdStore());
		orderItemDTO.setIdProduct(item.getId().getIdProduct());
		orderItemDTO.setQuantity(item.getQuantity());
		orderItemDTO.setUnitPrice(item.getUnitPrice());
		
		return orderItemDTO;
	}
}
