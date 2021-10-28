package com.revature.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	private UserService uServ;

	public UserController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public UserController(UserService uServ) {
		super();
		this.uServ = uServ;
	}
	
	@GetMapping("/initial")
	public ResponseEntity<List<User>> insertInitialValues() {
		List<User> uList = new ArrayList<User>(Arrays.asList(new User("admin", "admin")));
		
		for(User u: uList) {
			uServ.insertUser(u);
		}
		
		return new ResponseEntity<List<User>>(uServ.getAllUser(), HttpStatus.OK);
	}
}
