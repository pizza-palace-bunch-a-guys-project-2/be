package com.revature.repositories;

import org.springframework.stereotype.Repository;

import com.revature.models.Item;
import com.revature.models.Type;

//@Repository
public interface TypeRepository {
	
	public void InsertType(Type type);
	
}
