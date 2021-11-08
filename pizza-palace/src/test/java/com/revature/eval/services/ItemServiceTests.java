package com.revature.eval.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.log.ItemLog;
import com.revature.models.Item;
import com.revature.repositories.ItemRepository;
import com.revature.services.ItemService;

@SpringBootTest
public class ItemServiceTests {
	
	@Mock
	private ItemRepository itemRepo;
	
	@Mock
	private ItemLog itemLog;
	
	private ItemService itemServ;
	
	private List<Item> testList;
	
	private Item testItem0;
	private Item testItem1;
	
	

	@SuppressWarnings("deprecation")
	@BeforeEach 
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		itemServ = new ItemService(itemRepo, itemLog);
		
		testItem0 = new Item("Type", "item", 0, "#", "description");
		testItem1 = new Item("Type", "itemName", 0, "#", "description");
		
		testList = new ArrayList<Item>();
		testList.add(testItem0);
		testList.add(testItem1);
		
		when(itemRepo.findByItemName("itemName")).thenReturn(testItem1);
		when(itemRepo.findAll()).thenReturn(testList);
	}
	
	@Test
	public void insertItemSuccess() {
		assertEquals(itemServ.insertItem(testItem0), testItem0);
	}
	
	@Test
	public void insertItemUnsuccess() {
		assertEquals(itemServ.insertItem(testItem1), null);
	}
	
	
	@Test
	public void findAllItemsSuccess() {
		assertEquals(itemServ.findAllItems(), testList);
	}
	
}
