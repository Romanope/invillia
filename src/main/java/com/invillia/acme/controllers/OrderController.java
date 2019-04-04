package com.invillia.acme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.dto.OrderDTO;
import com.invillia.acme.dto.OrderItemDTO;
import com.invillia.acme.exceptions.BusinessException;
import com.invillia.acme.services.OrderItemService;
import com.invillia.acme.services.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService itemService;
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public List<OrderDTO> orders () {
		
		return orderService.listAllDTO();
	}

	@RequestMapping(value = "/orders/{storeId}/{dateTime}", method = RequestMethod.GET)
	public OrderDTO orders (@PathVariable(value = "storeId") Long storeId, 
			@PathVariable(value = "dateTime") String dateTime) throws BusinessException {
		
		
		return orderService.findByIdDTO(storeId, dateTime);
	}
	
	@RequestMapping(value = "/orders/{storeId}/{dateTime}/items", method = RequestMethod.GET)
	public List<OrderItemDTO> Items (@PathVariable(value = "storeId") Long storeId, 
			@PathVariable(value = "dateTime") String dateTime) throws BusinessException {
		
		return itemService.listItemsOrderByOrderDTO(storeId, dateTime);
	}
	
	@PostMapping("/orders")
	public OrderDTO createOrder (@RequestBody OrderDTO order) throws BusinessException {
			
		return orderService.insert(order);
	}
}
