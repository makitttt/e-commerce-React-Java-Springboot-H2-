package com.xyz.service;

import java.util.List;

import com.xyz.model.ProductDto;
import com.xyz.repository.Product;

public interface ProductService {

	void save(ProductDto user);
	
	List<Product> findAll();
	
    Product getProductById(int id);

    void update(int id, int quantity);
}
