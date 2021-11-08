package com.revature.eval.controllers;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.OrderController;
import com.revature.log.ItemLog;
import com.revature.models.Order;
import com.revature.repositories.OrderRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.OrderService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTests {
	
//	@InjectMocks
//	private OrderController oCon;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OrderService oServ;
	private Order order;

	
	
	
	@BeforeEach
	public void setUp() throws Exception{
		
		
		
		order = new Order(1, "Test Item List", "Test Payment Details", "Test Address", 10f, 1);
		
		doNothing().when(oServ).insertOrder(order);
		
	}
	
	@Test
	public void testInsertOrderSuccess() throws Exception {
		
			this.mockMvc.perform(post("/checkout/orderplaced")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(order)))
				.andExpect(status().isCreated());

	}
		
}
