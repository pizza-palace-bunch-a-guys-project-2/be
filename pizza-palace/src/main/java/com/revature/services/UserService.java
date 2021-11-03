package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.utils.EmailSender;
import com.revature.utils.PasswordEncrypter;

@Service
public class UserService {
	private UserRepository uRepo;
	private EmailSender email = new EmailSender();
	private PasswordEncrypter encr = new PasswordEncrypter();
	private String salt = "itMbrvNjVoId0qpezuvwvWIcybb0rI";

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
	
	public User insertUser(User user) {
		User verifyUser = uRepo.findByUserName(user.getUserName());
		if (verifyUser != null) {
			System.out.println("User already exist");
			return null;
		}
		
		String pass = user.getUserPassword();
		
		user.setUserPassword(getEncrypteString(pass));
		uRepo.save(user);
		
		email.sendEmail(user.getUserEmail(), "User account: " + user.getUserName() +" created", "Account password: " + pass);
		
		return uRepo.findByUserName(user.getUserName());
	}
	
	public User updateUser(User user) {
		User updatedUser = uRepo.findByUserName(user.getUserName());
		
		if(updatedUser == null) {
			System.out.println("Such user doesn't exist");
			return null;
		}
		
		uRepo.delete(updatedUser);
		
		String pass = user.getUserPassword();
		
		updatedUser.setUserPassword(getEncrypteString(pass));
		updatedUser.setUserFirstName(user.getUserFirstName());
		updatedUser.setUserLastName(user.getUserLastName());
		updatedUser.setUserEmail(user.getUserEmail());
		updatedUser.setUserAddress(user.getUserAddress());
		updatedUser.setUserCity(user.getUserCity());
		updatedUser.setUserState(user.getUserState());
		updatedUser.setUserZip(user.getUserZip());
		
		uRepo.save(updatedUser);
		
		email.sendEmail(user.getUserEmail(), "User account: " + user.getUserName() +" updated", "Account password: " + pass);
		
		return uRepo.findByUserName(updatedUser.getUserName());
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
	
	public User verifyPassword(User user) {
		User verifyUser = uRepo.findByUserName(user.getUserName());
		
		System.out.println("Verify User: " + verifyUser);
		
		if (verifyUser == null) {
			System.out.println("There no such user");
			return null;
		}
		
		if(!getEncrypteString(user.getUserPassword()).equals(verifyUser.getUserPassword())) {
			System.out.println("Passwords didn't matched");
			return null;
		}
		
		return verifyUser;
	}
	
	public String getEncrypteString(String str) {
		return this.encr.generateSecurePassword(str, salt);
	}
	
}
