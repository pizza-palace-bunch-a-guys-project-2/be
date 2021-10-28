package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository uRepo;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public UserService(UserRepository uRepo) {
		super();
		this.uRepo = uRepo;
	}
	
	public List<User> getAllUser() {
		return uRepo.findAll();
	}
	
	public void insertUser(User user) {
		uRepo.save(user);
	}
	
	public User getUserByName(String name) {
		return uRepo.findByUserName(name);
	}
	
	public User getUserById(int id) {
		return uRepo.findByUserId(id);
	}
	
	public void deleteUser(User user) {
		uRepo.delete(user);
	}
}
