package com.arief.mvc.services;

import com.arief.mvc.entity.Product;

public interface ProductService extends GenericBaseDAO<Product, String>{
	public void buyProduct(int qty,String id);
}
