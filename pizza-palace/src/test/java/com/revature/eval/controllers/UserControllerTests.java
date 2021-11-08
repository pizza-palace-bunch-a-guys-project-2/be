package com.revature.eval.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.UserController;
import com.revature.log.UserLog;
import com.revature.models.User;
import com.revature.services.UserService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTests {
	
	@MockBean
	private UserService uServ;
	
	@MockBean 
	private UserLog userLog;
	
	private User user;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() throws Exception {
		userLog = Mockito.mock(UserLog.class);
		uServ = Mockito.mock(UserService.class);
		user = new User(0, "username", "password", "email", "firstname", "lastname", "address", "city", "state", "zip");
		doNothing().when(userLog).infoLogger(null);
		doNothing().when(userLog).exceptionLog(null);
		doNothing().when(userLog).errorLogger(null);
		doNothing().when(uServ).deleteUser(user);
		when(uServ.insertUser(user)).thenReturn(null);
		when(uServ.getUserByName("username")).thenReturn(user);
	}
	
	@Test 
	public void getUserTestNull() throws Exception {
		this.mockMvc.perform(get("/users/{users}", this.user.getUserName())).andExpect(status().isNotFound());
	}
	
	@Test 
	public void insertUserTestNull() throws Exception {
		this.mockMvc.perform(post("/users")
			.contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(user)))
			.andExpect(status().isForbidden());
	}
}
