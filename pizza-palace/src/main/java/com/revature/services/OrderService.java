package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Order;
import com.revature.models.User;
import com.revature.repositories.OrderRepository;
import com.revature.repositories.UserRepository;
import com.revature.utils.EmailSender;

@Service
public class OrderService {
	
	private EmailSender email = new EmailSender();
	
	private OrderRepository oRepo;
	
	private UserRepository uRepo;
	
	public OrderService() {}
	
	
	
	
	@Autowired
	public OrderService(OrderRepository oRepo, UserRepository uRepo) {
		super();
		this.oRepo=oRepo;
		this.uRepo=uRepo;
	}
	
	public void insertOrder(Order order) {
		oRepo.save(order);
		User umod = uRepo.findByUserId(order.getUserId());
		email.sendEmail(umod.getUserEmail(), "Order Confirmation", order.toStringEmail());
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
