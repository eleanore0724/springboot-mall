package com.AAA.service;

import java.util.List;

import com.AAA.dto.CreateOrderRequest;
import com.AAA.dto.OrderQueryParams;
import com.AAA.model.Order;

public interface OrderService {
	Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
	
	Order getOrderById(Integer orderId);
	
	Integer countOrder(OrderQueryParams orderQueryParams);
	List<Order> getOrders(OrderQueryParams orderQueryParams);
}
