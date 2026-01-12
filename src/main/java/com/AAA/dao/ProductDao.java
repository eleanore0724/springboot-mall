package com.AAA.dao;

import com.AAA.dto.ProductRequest;
import com.AAA.model.Product;

public interface ProductDao {
	Product getProductById(Integer productId);
	
	Integer createProduct(ProductRequest productRequest);
	
	void updateProduct(Integer productId, ProductRequest productRequest);
	
	void deleteProductById(Integer productId);
}
