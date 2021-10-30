package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Item;
import com.revature.models.User;

@Repository
public interface ItemRepository extends CrudRepository<Item, String> {
	
	public List<Item> findAll();
	//public void insertItem(Item item);
	public Item findByItemName(String itemName);
	/*
	 * public Item findByItemId(int id); public Item findByItemName(String
	 * itemName);
	 */
}
