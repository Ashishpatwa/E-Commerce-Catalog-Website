package com.nagarro.productCatalogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.productCatalogs.model.Product;
import com.nagarro.productCatalogs.repository.ProductRepository;
import com.nagarro.productCatalogs.repository.SearchRepository;
import com.nagarro.productCatalogs.services.ProductService;

@RestController
@RequestMapping("/api/addProduct")
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	
	
	@PostMapping()
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<Product> getAllProduct(){
		return this.productService.getAllProducts();
	}
	

	@GetMapping("/details/{id}")
    public String getDetails(@PathVariable("id") String keyword) {
		
		List<Product> details = productRepository.findByProductCodeContainingIgnoreCase(keyword);
        return details.get(0).getDetails();
    }
	
	@GetMapping("/price/{id}")
    public int getPrice(@PathVariable("id") String keyword) {
	
		List<Product> details = productRepository.findByProductCodeContainingIgnoreCase(keyword);
        return details.get(0).getPrice();
    }


	
	
}
