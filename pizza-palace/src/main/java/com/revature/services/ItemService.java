package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Item;
import com.revature.repositories.ItemRepository;

@Service
public class ItemService {

	private ItemRepository itemRepo;
	
	public ItemService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public ItemService(ItemRepository itemRepo) {
		super();
		this.itemRepo = itemRepo;
	}
	
	public List<Item> findAllItems() {
		return itemRepo.findAll();
	}
	
	public Item insertItem(Item item) {
		
//		Item verifyItem = itemRepo.findByItemName(item.getName());
//		
//		if(verifyItem != null) {
//			System.out.println("Item already inserted: " + item.toString());
//			return null;
//		}
		
		itemRepo.save(item);
		
		return item;
	}
	
	
}
