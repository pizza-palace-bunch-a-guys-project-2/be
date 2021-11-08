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

import com.revature.log.UserLog;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping(value="/users")
@CrossOrigin(origins="*")
public class UserController {
	private UserService uServ;
	private UserLog userLog;

	public UserController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public UserController(UserService uServ, UserLog userLog) {
		super();
		this.uServ = uServ;
		this.userLog = userLog;
	}
	
	@GetMapping("/initial")
	public ResponseEntity<List<User>> insertInitialValues() {
		userLog.infoLogger("UserController: insertInitialValues() invoked.");
		List<User> uList = new ArrayList<User>(Arrays.asList(new User("admin", "admin")));
		
		for(User u: uList) {
			uServ.insertUser(u);
		}
		
		return new ResponseEntity<List<User>>(uServ.getAllUser(), HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<User>> getAllUser() {
		userLog.infoLogger("UserController: getAllUser() invoked.");
		return new ResponseEntity<List<User>>(uServ.getAllUser(), HttpStatus.OK);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<User> getUserByName(@PathVariable("username") String name) {
		userLog.infoLogger("UserController: getUserByName() invoked.");
		User user = uServ.getUserByName(name);
		if(user == null) {
			userLog.errorLogger("UserController: User with user name " + name + "wasn't found.");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		userLog.infoLogger("UserController: Sending user: " + user.toString());
		return new ResponseEntity<User>(uServ.getUserByName(name), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable("username") String name) {
		userLog.infoLogger("UserController: deleteUser() invoked.");
		User user = uServ.getUserByName(name);
		if(user == null) {
			userLog.errorLogger("UserController: User with user name " + name + "wasn't found.");
			return new ResponseEntity<String>("No User Of That Name: " + name, HttpStatus.NOT_FOUND);
		}
		
		uServ.deleteUser(user);
		userLog.infoLogger("UserController: Deleted user: " + user.toString());
		return new ResponseEntity<String>("User: " + name + " , was Deleted", HttpStatus.ACCEPTED);
	}
	
	@PostMapping()
	public ResponseEntity<Object> insertUser(@RequestBody User user) {
		userLog.infoLogger("UserController: insertUser() invoked.");
		
		User newUser = uServ.insertUser(user);
		
		if(newUser == null) {
			userLog.errorLogger("UserController: User: " + user.toString() + " already exists.");
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
		
		userLog.infoLogger("UserController: User: " + newUser.toString() + " was successfully added.");
		
		newUser.setUserPassword(null);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@PatchMapping()
	public ResponseEntity<Object> updateUser(@RequestBody User user) {
		userLog.infoLogger("UserController: updateUser() invoked.");
		
		User updatedUser = uServ.updateUser(user);
		
		if(updatedUser == null) {
			userLog.errorLogger("UserController: User: " + user.toString() + " didn't found.");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		userLog.infoLogger("UserController: User: " + updatedUser.toString() + " was successfully updated.");
		
		updatedUser.setUserPassword(null);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> loginUser(@RequestBody User user) {
		userLog.infoLogger("UserController: loginUser() invoked.");
		
		User verifiedUser = uServ.verifyPassword(user);
		
		if(verifiedUser == null) {
			userLog.errorLogger("UserController: Login User: " + user.toString() + " was unsuccessfull.");
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
		
		userLog.infoLogger("UserController: Login User: " + user.toString() + " was successfull.");
		
		verifiedUser.setUserPassword(null);
		return new ResponseEntity<>(verifiedUser, HttpStatus.OK);
	}
}
