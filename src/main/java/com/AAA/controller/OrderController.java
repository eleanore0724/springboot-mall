package com.AAA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AAA.dto.CreateOrderRequest;
import com.AAA.dto.OrderQueryParams;
import com.AAA.model.Order;
import com.AAA.service.OrderService;
import com.AAA.util.Page;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Validated
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService; 
	
	@PostMapping("/users/{userId}/orders")
	public ResponseEntity<?> createOrder(@PathVariable Integer userId, @RequestBody @Valid CreateOrderRequest createOrderRequest){
		
		
		Integer orderId=orderService.createOrder(userId, createOrderRequest);
		
		Order order =orderService.getOrderById(orderId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}
	
	@GetMapping("/users/{users}/orders")
	public ResponseEntity<Page<Order>> getOrder(
		@PathVariable Integer users, 
		@RequestParam(defaultValue = "10") @Max(1000) @Min(0) Integer limit, 
		@RequestParam(defaultValue = "0") @Min(0) Integer offset
	){
		OrderQueryParams orderQueryparams =new OrderQueryParams();
		orderQueryparams.setUserId(users);
		orderQueryparams.setLimit(limit);
		orderQueryparams.setOffset(offset);
		
		//取得order list
		List<Order> orderList = orderService.getOrders(orderQueryparams);
		
		//取得order 總數
		Integer count =orderService.countOrder(orderQueryparams);
		
		//分頁
		Page<Order> page = new Page<>();
		page.setLimit(limit);
		page.setOffset(offset);
		page.setTotal(count);
		page.setResult(orderList);
		
		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
}
