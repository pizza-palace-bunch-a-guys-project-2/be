package com.revature.eval.services;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.repositories.UserRepository;

public class UserServiceTests {
	
	@Mock
	private UserRepository uRepo;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
//		uRepo = new UserRepository();
	}
}
