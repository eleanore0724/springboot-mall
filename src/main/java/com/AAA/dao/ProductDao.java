package com.AAA.dao;

import java.util.List;

import com.AAA.dto.ProductRequest;
import com.AAA.model.Product;

public interface ProductDao {
	
	List<Product> getProducts();
	
	Product getProductById(Integer productId);
	
	Integer createProduct(ProductRequest productRequest);
	
	void updateProduct(Integer productId, ProductRequest productRequest);
	
	void deleteProductById(Integer productId);
}
