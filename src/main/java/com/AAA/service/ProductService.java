package com.AAA.service;

import com.AAA.dto.ProductRequest;
import com.AAA.model.Product;

public interface ProductService {
	Product getProductById(Integer productId);
	
	Integer createProduct(ProductRequest productRequest);
}
