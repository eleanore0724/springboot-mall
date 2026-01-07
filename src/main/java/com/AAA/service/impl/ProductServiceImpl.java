package com.AAA.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AAA.dao.ProductDao;
import com.AAA.model.Product;
import com.AAA.service.ProductService;


@Component
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product getProductById(Integer productId) {
		return productDao.getProductById(productId);
	}
	
}
