package com.revature.eval.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.log.UserLog;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.UserService;
import com.revature.utils.EmailSender;
import com.revature.utils.PasswordEncrypter;

public class UserServiceTests {
	
	@Mock
	private UserRepository uRepo;
	private UserLog userLog;
	private EmailSender email;
	private PasswordEncrypter encr;
	private UserService uServ;
	private List<User> usersList;
	private User testUser1;
	private User testUser2;
	
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		uServ = new UserService(uRepo, userLog, email, encr);
		
		testUser1 = new User(1, "test", "test", "test@test.com", "test", "test", "test_address", "test_city", "test_state", "test_zip");
		testUser2 = new User(2, "test2", "test", "test@test.com", "test", "test", "test_address", "test_city", "test_state", "test_zip");
		
		usersList = new ArrayList<User>();
		
		usersList.add(testUser1);
		
		
		when(uRepo.findByUserName("test")).thenReturn(testUser1);
		when(uRepo.findByUserId(1)).thenReturn(testUser1);
		when(uRepo.findAll()).thenReturn(usersList);
		when(uRepo.findByUserName("test2")).thenReturn(testUser2);
	}
	
	@Test
	public void getUserByNameSuccess() {
		assertEquals(uServ.getUserByName("test"), testUser1);
	}
	
	@Test
	public void getUserByNameUnsuccess() {
		assertEquals(uServ.getUserByName("testing"), null);
	}
	
	@Test
	public void getUserByIdSuccess() {
		assertEquals(uServ.getUserById(1), testUser1);
	}
	
	@Test
	public void getUserByIdUnsuccess() {
		assertEquals(uServ.getUserById(0), null);
	}
	
	@Test
	public void getAllUserSuccess() {
		assertEquals(uServ.getAllUser(), usersList);
	}
	
	
}
