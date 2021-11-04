package com.revature.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping(value="/users")
@CrossOrigin(origins="*")
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
		
		return new ResponseEntity<List<User>>(uServ.getAllUser(), HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<User>> getAllUser() {
		return new ResponseEntity<List<User>>(uServ.getAllUser(), HttpStatus.OK);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<User> getUserByName(@PathVariable("username") String name) {
		User user = uServ.getUserByName(name);
		if(user == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(uServ.getUserByName(name), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable("username") String name) {
		User user = uServ.getUserByName(name);
		if(user == null) {
			return new ResponseEntity<String>("No User Of That Name: " + name, HttpStatus.NOT_FOUND);
		}
		
		uServ.deleteUser(user);
		return new ResponseEntity<String>("User: " + name + " ,Was Deleted", HttpStatus.ACCEPTED);
	}
	
	@PostMapping()
	public ResponseEntity<Object> insertUser(@RequestBody User user) {
		System.out.println("User JSON: " + user);
		
		User newUser = uServ.insertUser(user);
		
		if(newUser == null) {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
		
		newUser.setUserPassword(null);
		
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@PatchMapping()
	public ResponseEntity<Object> updateUser(@RequestBody User user) {
		System.out.println("User JSON: " + user);
		
		User updatedUser = uServ.updateUser(user);
		
		if(updatedUser == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		updatedUser.setUserPassword(null);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> loginUser(@RequestBody User user) {
		System.out.println("User JSON: " + user);
		
		User verifiedUser = uServ.verifyPassword(user);
		
		if(verifiedUser == null) {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
		
		verifiedUser.setUserPassword(null);
		
		return new ResponseEntity<>(verifiedUser, HttpStatus.OK);
	}
}
