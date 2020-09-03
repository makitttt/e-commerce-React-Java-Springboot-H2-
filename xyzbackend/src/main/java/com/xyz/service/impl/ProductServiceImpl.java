package com.xyz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.model.ProductDto;
import com.xyz.repository.Product;
import com.xyz.repository.ProductRepository;
import com.xyz.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	@Override
	public Product getProductById(int id) {
		Optional<Product> product = productRepository.findById(id);
		return product.get();
	}

    @Override
    public void update(int id, int quantity) {
    	Optional<Product> product = productRepository.findById(id);
    	product.get().setStock(product.get().getStock()-quantity);
        productRepository.save(product.get());
    }

    @Override
    public void save(ProductDto productDto) {
    	Product product = new Product(productDto.getName(), productDto.getPrice(), productDto.getStock(), productDto.getShortDesc());
        productRepository.save(product);
    }
}
