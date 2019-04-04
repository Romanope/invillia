package com.invillia.acme.services;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.invillia.acme.dao.OrderItemDAO;
import com.invillia.acme.exceptions.BusinessException;
import com.invillia.acme.mappers.OrderItemMapper;
import com.invillia.acme.model.OrderItem;
import com.invillia.acme.model.validators.OrderItemValidator;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemServiceTest {

	
	private static final String DATA_VALIDA = "21/01/2016'T'12:33:45";

	private static final long STORE_ID = 100L;

	@Mock
	private OrderItemDAO dao;
	
	@Mock
	private OrderItemValidator validator;
	
	@Mock
	private List<OrderItem> items;
	
	@InjectMocks
	private OrderItemService service = new OrderItemService();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void deveLancarExcecaoQuandoOcorrerErroDeValidacao () throws BusinessException {
		thrown.expect(BusinessException.class);
		
		doThrow(new BusinessException()).when(validator).validate(STORE_ID, null);
		
		service.listItemsOrderByOrder(STORE_ID, null);
	}

	@Test
	public void deveRetornarListaDeItensQuandoConsultaValida () throws BusinessException {
		doNothing().when(validator).validate(STORE_ID, DATA_VALIDA);
		
		when(dao.listItemsOrderByOrder(STORE_ID, DATA_VALIDA)).thenReturn(items);
		
		List<OrderItem> returnReceived = service.listItemsOrderByOrder(STORE_ID, DATA_VALIDA);
		
		verify(validator).validate(STORE_ID, DATA_VALIDA);
		verify(dao).listItemsOrderByOrder(STORE_ID, DATA_VALIDA);
		
		assertSame(items, returnReceived);
	}
}
