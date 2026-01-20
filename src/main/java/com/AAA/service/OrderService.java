package com.AAA.service;

import com.AAA.dto.CreateOrderRequest;
import com.AAA.model.Order;

public interface OrderService {
	Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
	
	Order getOrderById(Integer orderId);
}
