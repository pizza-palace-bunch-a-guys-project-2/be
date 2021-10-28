package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
	public List<User> findAll();
	public User findByUserName(String userName);
	public User findByUserId(int id);
}
