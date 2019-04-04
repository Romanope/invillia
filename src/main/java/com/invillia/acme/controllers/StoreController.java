package com.invillia.acme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.exceptions.BusinessException;
import com.invillia.acme.model.Store;
import com.invillia.acme.services.StoreService;

@RestController
public class StoreController {
	
	@Autowired
	private StoreService service;
	
	@GetMapping("/stores")
	public List<Store> stores () {
		
		return service.listAll();
	}

	@GetMapping("/stores/{id}")
	public Store stores (@PathVariable Long id) {
		
		return service.findById(id);
	}

	@GetMapping("/stores/storefilter")
	public List<Store> stores (@RequestParam(name="name", required = false) String name, 
			@RequestParam(name="id", required = false) Long id) {
		
		return service.searchStores(name, id);
	}
	
	@PostMapping("/stores")
	public Store create (@RequestBody Store store) throws BusinessException {
		
		service.save(store);
		
		return store;
	}
	
	@PutMapping("/stores")
	public Store updateStore (@RequestBody Store store) throws BusinessException {
		
		service.update(store);
		
		return store;
	}
}
