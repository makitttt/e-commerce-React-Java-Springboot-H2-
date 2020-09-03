package com.xyz.model;

import java.io.Serializable;

public class ProductDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4097468488440249149L;
	
	private int id;
	private String name;
	private double price;
	private String shortDesc;
	private int stock;

	public ProductDto(int id, String username, String description) {
		super();
		this.id = id;
		this.name = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}