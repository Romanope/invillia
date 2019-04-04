package com.invillia.acme.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.invillia.acme.dto.OrderAddressDTO;
import com.invillia.acme.model.OrderAddress;

@Component
public class AddressMapper {

	public List<OrderAddress> toOrderAddress (List<OrderAddressDTO> addresses) {
		
		List<OrderAddress> result = new ArrayList<>();
		if (addresses != null) {
			for (OrderAddressDTO orderDTO : addresses) {
				result.add(toOrderAddress(orderDTO));
			}
		}
		
		return result;
	}
	
	public OrderAddress toOrderAddress (OrderAddressDTO address) {
		
		if (address == null) {
			return null;
		}
		
		OrderAddress orderAddress = new OrderAddress();
		orderAddress.setCity(address.getCity());
		orderAddress.setCountry(address.getCountry());
		orderAddress.setFu(address.getFu());
		orderAddress.setNeighborhood(address.getNeighborhood());
		orderAddress.setNumber(address.getNumber());
		orderAddress.setPostalCode(address.getPostalCode());
		orderAddress.setStreet(address.getStreet());
		
		return orderAddress;
	}

	public OrderAddressDTO toOrderAddressDTO (OrderAddress address) {
		
		if (address == null) {
			return null;
		}
		
		OrderAddressDTO orderAddressDTO = new OrderAddressDTO();
		orderAddressDTO.setCity(address.getCity());
		orderAddressDTO.setCountry(address.getCountry());
		orderAddressDTO.setFu(address.getFu());
		orderAddressDTO.setNeighborhood(address.getNeighborhood());
		orderAddressDTO.setNumber(address.getNumber());
		orderAddressDTO.setPostalCode(address.getPostalCode());
		orderAddressDTO.setStreet(address.getStreet());
		orderAddressDTO.setId(address.getId());
		
		return orderAddressDTO;
	}
	
	public List<OrderAddressDTO> toOrderAddressDTO (List<OrderAddress> addresses) {
		
		List<OrderAddressDTO> result = new ArrayList<>();
		if (addresses != null) {
			for (OrderAddress orderDTO : addresses) {
				result.add(toOrderAddressDTO(orderDTO));
			}
		}
		
		return result;
	}
}
