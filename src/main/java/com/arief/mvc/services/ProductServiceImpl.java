package com.arief.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arief.mvc.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO dao;
	
	@Override
	public void save(Product t) {
		dao.save(t);
	}

	@Override
	public List<Product> getAll() {
		return dao.getAll();
	}

	@Override
	public void delete(String id) {
		dao.delete(id);
	}

	@Override
	public Product getOne(String id) {
		return dao.getOne(id);
	}

	@Override
	public void update(Product t) {
		dao.update(t);
	}

	@Override
	public void buyProduct(int qty, String id) {
		dao.buyProduct(qty, id);
	}

}
