package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Type;
import com.revature.repositories.TypeRepository;

//@Service
public class TypeService {
	
	private TypeRepository typeRepo;
	
	
	public TypeService() {
		// TODO Auto-generated constructor stub
	}
	
	//@Autowired
	public TypeService(TypeRepository typeRepo) {
		super();
		this.typeRepo = typeRepo;
	}

	public Type insertType(Type type) {
		typeRepo.InsertType(type);
		return type;
	}
	
}
