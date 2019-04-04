package com.invillia.acme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.invillia.acme.dao.StoreDAO;
import com.invillia.acme.exceptions.BusinessException;
import com.invillia.acme.model.Store;
import com.invillia.acme.model.StoreAddress;
import com.invillia.acme.model.validators.StoreValidator;

@Component
public class StoreService extends AbstractService<Store, Long> {

	@Autowired
	private StoreDAO dao;

	@Autowired
	private StoreAddressService addressService;
	
	@Autowired
	private StoreValidator validator;
	
	public StoreService() {
		super();
	}
	
	@Override
	@Transactional
	public void save (Store obj) throws BusinessException {
		
		validator.validate(obj);
		
		super.save(obj);
		
		for (StoreAddress address : obj.getAddresses()) {
			address.setStore(obj);
			addressService.save(address);
			address.setStore(null); // Solução temporária para o jackson-bind não cair no loop. Criar DTO/VO para retorno
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Store> listAll () {
		
		List<Store> stores = super.listAll();
		
		toRemoveStoreFromAddress(stores);
		
		return stores;
	}

	private List<Store> toRemoveStoreFromAddress(List<Store> stores) {
		for (Store store : stores) {
			if (store.getAddresses() != null) {
				for (StoreAddress add : store.getAddresses()) {
					add.setStore(null); // Solução temporária para o jackson-bind não cair no loop. Criar DTO/VO para retorno
				}
			}
		}
		
		return stores;
	}
	
	@Transactional(readOnly = true)
	public List<Store> searchStores (String name, Long id) {
		
		return toRemoveStoreFromAddress(dao.searchStores(name, id));
	}
	

	@Override
	public CrudRepository<Store, Long> getDao() {

		return this.dao;
	}
}
