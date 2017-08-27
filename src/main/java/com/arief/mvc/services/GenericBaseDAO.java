package com.arief.mvc.services;

import java.io.Serializable;
import java.util.List;

public interface GenericBaseDAO<T,ID extends Serializable> {
	
	void save(T t);
	List<T> getAll();
	void delete (ID id);
	T getOne(ID id);
	void update(T t);
}
