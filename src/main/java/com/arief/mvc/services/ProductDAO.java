package com.arief.mvc.services;


import com.arief.mvc.entity.*;


public interface ProductDAO extends GenericBaseDAO<Product, String>{
	public void buyProduct(int qty,String id);
}
