package com.xyz.model;

import java.io.Serializable;

public class ProductQuantity implements Serializable {
	
	private int id;
	
	private int quantity;
	
	public ProductQuantity() {
		
	}
	
	public ProductQuantity(int id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductQuantity [id=" + id + ", quantity=" + quantity + "]";
	}
	
	

}
