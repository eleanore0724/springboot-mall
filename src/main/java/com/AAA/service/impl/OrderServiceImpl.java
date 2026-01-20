package com.AAA.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.AAA.dao.OrderDao;
import com.AAA.dao.ProductDao;
import com.AAA.dao.UserDao;
import com.AAA.dto.BuyItem;
import com.AAA.dto.CreateOrderRequest;
import com.AAA.model.Product;
import com.AAA.model.User;
import com.AAA.model.Order;
import com.AAA.model.OrderItem;
import com.AAA.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService{
	
	private final static Logger log =LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
		//檢查user是否存在
		User user =userDao.getUserById(userId);
		
		if(user == null) {
			log.warn("該userId {} 不存在", userId);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		List<OrderItem> orderItemList =new ArrayList<OrderItem>();
		int totalAmount = 0;
		
		//檢查 product 是否存在、庫存是否足夠
		for(BuyItem buyItem : createOrderRequest.getBuyItemList()) {
			Product product =productDao.getProductById(buyItem.getProductId());

			if(product ==null) {
				log.warn("商品 {} 不存在",buyItem.getProductId());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}else if(product.getStock() < buyItem.getQuantity()) {
				log.warn("商品 {} 庫存不足，無法購買！剩餘庫存{} ，欲購買數量{}", buyItem.getProductId(), product.getStock(), buyItem.getQuantity());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			
			//扣除商品庫存
			productDao.updateStock(product.getProductId(),product.getStock()- buyItem.getQuantity());
		}
		
		
		
		//計算訂單總價錢
	
		for(BuyItem buyItem : createOrderRequest.getBuyItemList()) {
			Product product = productDao.getProductById(buyItem.getProductId());
			
			int amount = buyItem.getQuantity() * product.getPrice();
			totalAmount = totalAmount + amount;
			
			//轉換BuyItem to OrderItem
			OrderItem orderItem =new OrderItem();
			orderItem.setProductId(buyItem.getProductId());
			orderItem.setQuantity(buyItem.getQuantity());
			orderItem.setAmount(amount);
			orderItemList.add(orderItem);
		}
		
		// 創建訂單
		Integer orderId =orderDao.createOrder(userId, totalAmount);
		
		orderDao.createOrderItems(orderId, orderItemList);
		
		return orderId;
	}

	@Override
	public Order getOrderById(Integer orderId) {
		Order order = orderDao.getOrderById(orderId);
		
		List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);
		
		order.setOrderItemList(orderItemList);
		return order;
	}
}
