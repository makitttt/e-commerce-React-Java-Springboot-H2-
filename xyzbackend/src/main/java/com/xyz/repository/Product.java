package com.xyz.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "shortDesc")
	private String shortDesc;
	
	@Column(name = "stock")
	private int stock;
	
	public Product() {
		super();
	}

	public Product(String name, double price, int stock, String shortDesc) {
		this.name = name;
		this.price = price;
		this.shortDesc = shortDesc;
		this.stock = stock;
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
	

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", shortDesc=" + shortDesc + ", stock="
				+ stock + "]";
	}

}