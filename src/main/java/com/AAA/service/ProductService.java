package com.AAA.service;

import java.util.List;

import com.AAA.dto.ProductRequest;
import com.AAA.model.Product;

public interface ProductService {
	
	List<Product> getProducts();
	
	Product getProductById(Integer productId);
	
	Integer createProduct(ProductRequest productRequest);
	
	void updateProduct(Integer productId, ProductRequest productRequest);
	
	void deleteProductById(Integer productId);
}
