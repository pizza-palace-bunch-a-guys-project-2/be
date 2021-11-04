package com.revature.eval.services;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import com.revature.models.Item;
import com.revature.repositories.ItemRepository;
import com.revature.services.ItemService;

@SpringBootTest
public class ItemServiceTests {
	
	@Mock
	private ItemRepository itemRepo;
	
	@Mock
	private ItemService itemServ;
	
	@Mock
	private Item testItem;

	@SuppressWarnings("deprecation")
	@BeforeEach 
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		testItem.setType("pizza");
		testItem.setPrice(15);
		testItem.setItemName("Cheese Pizza");
		testItem.setImageURL("#");
		testItem.setDescription("test item");
	}
	
}
