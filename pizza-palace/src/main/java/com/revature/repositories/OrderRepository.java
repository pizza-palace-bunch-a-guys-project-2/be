package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Order;

@Repository
public interface OrderRepository extends CrudRepository <Order, String>{
	public List<Order> findAll();
	public Order findByOrderId(int id);
	public List<Order> findByUserId(int id);
}
