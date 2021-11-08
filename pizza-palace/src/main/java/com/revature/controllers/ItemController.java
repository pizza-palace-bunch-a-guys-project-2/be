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

import com.revature.log.ItemLog;
import com.revature.models.Item;
import com.revature.models.User;
import com.revature.services.ItemService;

@RestController
@RequestMapping(value="/items")
@CrossOrigin(origins="*")
public class ItemController {

	private ItemService itemServ;
	private ItemLog itemLog;
	
	public ItemController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public ItemController(ItemService itemServ, ItemLog itemLog) {
		super();
		this.itemServ = itemServ;
		this.itemLog = itemLog;
	}
	
	@GetMapping()
	public ResponseEntity<List<Item>> getAllItems() {
		itemLog.infoLogger("ItemController: Get request received responding with all menu items.");
		return new ResponseEntity<List<Item>>(itemServ.findAllItems(), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Object> insertItem(@RequestBody Item item) {
		itemLog.infoLogger("ItemController: insertItem() invoked");
		System.out.println(item);
		itemServ.insertItem(item);
		itemLog.infoLogger("ItemController: " + item.toString() + " sent to service.");
		return new ResponseEntity<>(item.getItemName() + " inserted", HttpStatus.CREATED);
	}
	
	@PostMapping("/initMenu")
	public ResponseEntity<Object> insertInitMenu(@RequestBody List<Item> items) {
		itemLog.infoLogger("ItemController: insertInitMenu() invoked.");
		List<Item> checkDB = new ArrayList<>();
		checkDB = itemServ.findAllItems();
		if(checkDB.size() > 0) {
			itemLog.infoLogger("ItemController: Blocked attempted duplicate menu.");
			return new ResponseEntity<>("A Menu Already Exists", HttpStatus.FORBIDDEN);
		}
		for(Item item: items) {
			itemServ.insertItem(item);
		}
		itemLog.infoLogger("ItemController: New menu created.");
		return new ResponseEntity<>("Menu Created", HttpStatus.CREATED);
	}
	
	

}
 