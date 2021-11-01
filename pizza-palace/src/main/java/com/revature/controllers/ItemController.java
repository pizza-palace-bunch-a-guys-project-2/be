package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Item;
import com.revature.models.User;
import com.revature.services.ItemService;

@RestController
@RequestMapping(value="/items")
@CrossOrigin(origins="*")
public class ItemController {

	private ItemService itemServ;
	
	public ItemController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public ItemController(ItemService itemServ) {
		super();
		this.itemServ = itemServ;
	}
	
	@GetMapping()
	public ResponseEntity<List<Item>> getAllItems() {
		return new ResponseEntity<List<Item>>(itemServ.findAllItems(), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Object> insertItem(@RequestBody Item item) {
		System.out.println(item);
		itemServ.insertItem(item);
		return new ResponseEntity<>(item.getItemName() + " inserted", HttpStatus.CREATED);
	}
	
	@PostMapping("/initMenu")
	public ResponseEntity<Object> insertInitMenu(@RequestBody List<Item> items) {
		List<Item> checkDB = new ArrayList<>();
		checkDB = itemServ.findAllItems();
		if(checkDB.size() > 0) {
			return new ResponseEntity<>("A Menu Already Exists", HttpStatus.ALREADY_REPORTED);
		}
		for(Item item: items) {
			itemServ.insertItem(item);
		}
		return new ResponseEntity<>("Menu Created", HttpStatus.CREATED);
	}

}
 