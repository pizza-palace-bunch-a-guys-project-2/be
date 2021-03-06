package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Order;
import com.revature.models.User;
import com.revature.services.OrderService;
import com.revature.log.ItemLog;


@RestController
@RequestMapping(value="/checkout")
@CrossOrigin(origins="*")
public class OrderController {

	private OrderService oServ;
	
	private final ItemLog log = new ItemLog();;
	
	public OrderController() {}
	
	@Autowired
	public OrderController(OrderService oServ) {
		this.oServ=oServ;
	}
	
	
	@PostMapping(value="/orderplaced", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertOrder(@RequestBody LinkedHashMap<String, String> oMap) {
		
		System.out.println(oMap);
		String items = new String(oMap.get("items"));
		
		oServ.insertOrder(new Order(items, oMap.get("paymentDetails"), oMap.get("address"), Float.parseFloat(oMap.get("total")), Integer.parseInt(oMap.get("userId"))));
		log.infoLogger("OrderController: Post insertOrder Method");
		return new ResponseEntity<>("Order Successfully Placed", HttpStatus.CREATED);
	}
	
	@GetMapping("/initial")
	public ResponseEntity<List<Order>> insertInitialOrders(){
		
		List<Order> oList = new ArrayList<Order>(Arrays.asList(new Order("Cheese Pizza, Breadsticks", "Test Customer, 1234567, 09/23, 180", "1233 Sesame Street, NY 29384", 25f, 1), new Order 
				("Pepperoni Pizza, Cheesesticks", "Test2 Customer2, 123456, 09/13, 829", "3748 Fake Street, MN 72637", 28f, 2)));
		for(Order order : oList) {
			oServ.insertOrder(order);
		}
		log.infoLogger("OrderController: Get insertInit Method");
		return new ResponseEntity<List<Order>>(oServ.getAllOrders(), HttpStatus.CREATED);
	}
	

	
}

