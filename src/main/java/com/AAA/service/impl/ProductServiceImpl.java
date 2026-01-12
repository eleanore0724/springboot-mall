package com.AAA.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AAA.dao.ProductDao;
import com.AAA.dto.ProductRequest;
import com.AAA.model.Product;
import com.AAA.service.ProductService;


@Component
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}
	
	@Override
	public Product getProductById(Integer productId) {
		return productDao.getProductById(productId);
	}

	@Override
	public Integer createProduct(ProductRequest productRequest) {
		return productDao.createProduct(productRequest);
	}

	@Override
	public void updateProduct(Integer productId, ProductRequest productRequest) {
		productDao.updateProduct(productId, productRequest);
	}

	@Override
	public void deleteProductById(Integer productId) {
		productDao.deleteProductById(productId);
		
	}

	
}
