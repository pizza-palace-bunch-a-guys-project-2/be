package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Order;
import com.revature.repositories.OrderRepository;

@Service
public class OrderService {
	private OrderRepository oRepo;
	
	public OrderService() {}
	
	@Autowired
	public OrderService(OrderRepository oRepo) {
		super();
		this.oRepo=oRepo;
	}
	
	public void insertOrder(Order order) {
		oRepo.save(order);
	}
	
	public List<Order> getAllOrders(){
		return oRepo.findAll();
	}
	
	public Order getOrderById(int id) {
		return oRepo.findByOrderId(id);
	}
	
	public List<Order> getOrderByUserId(int id) {
		return oRepo.findByUserId(id);
	}
	
	public void deleteOrder(Order order) {
		oRepo.delete(order);
	}
	
	
	
}
