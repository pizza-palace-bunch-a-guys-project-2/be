package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Item;
import com.revature.models.Type;
import com.revature.services.TypeService;

/*@RestController
@RequestMapping(value="/types")
@CrossOrigin(origins="*")*/
public class TypeController {
	
	private TypeService typeServ;
	
	//@Autowired
	public TypeController() {
		// TODO Auto-generated constructor stub 
	}

	public TypeController(TypeService typeService) {
		super();
		this.typeServ = typeService;
	}
	
	/*
	 * //@PostMapping() public ResponseEntity<Object> insertType(@RequestBody Type
	 * type) { typeServ.insertType(type); return new
	 * ResponseEntity<>("Type Inserted", HttpStatus.CREATED); }
	 */
}
