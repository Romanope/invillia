package com.invillia.acme.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.invillia.acme.exceptions.BusinessException;

public abstract class AbstractService<T, I> {

	public abstract CrudRepository<T, I> getDao();
	
	public void save (T obj) throws BusinessException {
		
		if (obj == null) {
			throw new BusinessException("Entity is null");
		}
		try {
			getDao().save(obj);
		} catch (Exception e) {
			throw new BusinessException("Error while create record", e);
		}
	}
	
	public List<T> listAll () {
		
		return toList(getDao().findAll().iterator());
	}
	
	private List<T> toList (Iterator<T> result) {
		List<T> list = new ArrayList<>();
		while (result.hasNext()) {
			list.add(result.next());
		}
		
		return list;
	}
	
	public T findById (I id) {
		
		return getDao().findById(id).get();
	}
	
	public T update (T obj) {

		return getDao().save(obj);
	}
}
