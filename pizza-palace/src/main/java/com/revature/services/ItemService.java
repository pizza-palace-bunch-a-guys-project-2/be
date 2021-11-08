package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.log.ItemLog;
import com.revature.models.Item;
import com.revature.repositories.ItemRepository;

@Service
public class ItemService {

	private ItemRepository itemRepo;
	private ItemLog itemLog;
	
	public ItemService() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public ItemService(ItemRepository itemRepo, ItemLog itemLog) {
		super();
		this.itemRepo = itemRepo;
		this.itemLog = itemLog;
	}

	public List<Item> findAllItems() {
		itemLog.infoLogger("ItemService: Getting all items from DB.");
		return itemRepo.findAll();
	}
	
	public Item insertItem(Item item) {
		itemLog.infoLogger("ItemService: insertItem() invoked.");
		Item verifyItem = itemRepo.findByItemName(item.getItemName());
		
		if(verifyItem != null) {
			System.out.println("Item already inserted: " + item.toString());
			itemLog.infoLogger("ItemService: Item already exists");
			return null;
		}
		itemLog.infoLogger("ItemService: " + item.toString() + " added to DB.");
		itemRepo.save(item);
		
		return item;
	}
	
	
}
