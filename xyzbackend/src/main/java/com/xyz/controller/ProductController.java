package com.xyz.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz.model.ProductDto;
import com.xyz.model.ProductQuantity;
import com.xyz.repository.Product;
import com.xyz.service.ProductService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" }, maxAge = 3600)
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Void> saveProduct(@RequestBody ProductDto product){
        productService.save(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProducts(){
        return new ResponseEntity<>(productService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody List<ProductQuantity> productDto) throws IOException {
    	ArrayList<ProductQuantity> productQuantities = (ArrayList<ProductQuantity>) productDto;
    	for(ProductQuantity obj : productQuantities) {
    		int id =  obj.getId();
    		int quantity = obj.getQuantity();
    		productService.update(id,quantity);
    	}
        return ResponseEntity.ok().build();
    }

}
