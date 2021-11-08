package com.revature.eval.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.log.ItemLog;
import com.revature.models.Order;
import com.revature.models.User;
import com.revature.repositories.OrderRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.OrderService;



public class OrderServiceTests {

	@Mock
	private OrderRepository oRepo;
	private UserRepository uRepo;
	private OrderService oServ;
	private Order order;
	private List<Order> oList;
	private User user;
	
//	@MockBean
//	private OrderRepository oRepo;
//	private UserRepository uRepo;
	
	@BeforeEach
	public void setUp() throws Exception{
		
		MockitoAnnotations.initMocks(this);
		oServ = mock(OrderService.class);
		order = new Order(1, "Test Item List", "Test Payment Details", "Test Address", 10f, 1);
		oList = new ArrayList<Order>();
		oList.add(order);
		user = new User(1, "test", "test", "testemail", "testfname", "testlname", "testaddress", "testcity", "teststate", "testzip");
		when(oServ.getAllOrders()).thenReturn(oList);
		when(oServ.getOrdersByUserId(1)).thenReturn(oList);
		when(oServ.getOrderById(1)).thenReturn(order);
	}
	
	
	@Test
	public void testInsertOrderSuccess() {	
		oServ.insertOrder(order);
		verify(oServ).insertOrder(order);	
	}
	
	@Test
	public void testGetAllOrdersSuccess() {
		assertEquals(oServ.getAllOrders(), oList);
	}
	
	@Test
	public void testGetOrderById() {
		assertEquals(oServ.getOrderById(1), order);
	}
	
	@Test
	public void testGetOrdersByUserId() {
		assertEquals(oServ.getOrdersByUserId(1), oList);
	}
	
	@Test
	public void testDeleteOrder() {
		oServ.deleteOrder(order);
		verify(oServ).deleteOrder(order);
	}
	
}
