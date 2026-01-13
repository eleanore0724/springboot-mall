package com.AAA.dao;

import java.util.List;

import com.AAA.constant.ProductCategory;
import com.AAA.dto.ProductQueryParams;
import com.AAA.dto.ProductRequest;
import com.AAA.model.Product;

public interface ProductDao {
	
	List<Product> getProducts(ProductQueryParams productQueryParams);
	
	Product getProductById(Integer productId);
	
	Integer createProduct(ProductRequest productRequest);
	
	void updateProduct(Integer productId, ProductRequest productRequest);
	
	void deleteProductById(Integer productId);
}
