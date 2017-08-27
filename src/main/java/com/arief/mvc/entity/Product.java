package com.arief.mvc.entity;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class Product {
	
	
	
	private String id;
	
	
	
	@NotBlank(message="nama tidak boleh kosong")
	private String name;
	
	@Min(message="tidak boleh kurang dari 0",value=0)
	private float price;
	
	@Min(message="tidak boleh kurang dari 0 ",value=0)
	private int stock;
	
	
	public Product() {
		
	}
	
	
	
	public Product(String name, float price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	


	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	
}
