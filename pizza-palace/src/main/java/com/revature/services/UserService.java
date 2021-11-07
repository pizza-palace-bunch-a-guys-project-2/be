package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.log.UserLog;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.utils.EmailSender;
import com.revature.utils.PasswordEncrypter;

@Service
public class UserService {
	private UserRepository uRepo;
	private UserLog userLog;
	private EmailSender email;
	private PasswordEncrypter encr;
	private final String salt = "itMbrvNjVoId0qpezuvwvWIcybb0rI";

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public UserService(UserRepository uRepo, UserLog userLog, EmailSender email, PasswordEncrypter encr) {
		super();
		this.uRepo = uRepo;
		this.userLog = userLog;
		this.email = email;
		this.encr = encr;
	}

	public List<User> getAllUser() {
		userLog.infoLogger("UserService: Getting all users from DB.");
		return uRepo.findAll();
	}
	
	public User insertUser(User user) {
		userLog.infoLogger("UserService: insertUser() invoked.");
		User verifyUser = uRepo.findByUserName(user.getUserName());
		if (verifyUser != null) {
			userLog.errorLogger("UserService: User already exist");
			return null;
		}
		
		String pass = user.getUserPassword();
		
		user.setUserPassword(getEncrypteString(pass));
		uRepo.save(user);
		
		String htmlBody = "<h1>Thank you for creating an account with Us!</h1>\n"
				+ "<h2>Account name: " + user.getUserName() + "</h2>\n"
				+ "<h2>Account password: " + pass + "</h2>\n";
		
		email.sendHTMLEmail(user.getUserEmail(), "Creating account at Pizza Palace", email.HTMLWraper(htmlBody));
		
		userLog.infoLogger("UserService: " + user.toString() + " added to DB.");
		return uRepo.findByUserName(user.getUserName());
	}
	
	public User updateUser(User user) {
		userLog.infoLogger("UserService: updateUser() invoked.");
		User updatedUser = uRepo.findByUserName(user.getUserName());
		
		if(updatedUser == null) {
			userLog.errorLogger("UserService: Such user doesn't exist");
			return null;
		}
	
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
		
		String htmlBody = "<h1>Thank you for updating account information with Us!</h1>\n"
				+ "<h2>Account name: " + user.getUserName() + "</h2>\n"
				+ "<h2>Account password: " + pass + "</h2>\n";
		
		email.sendHTMLEmail(user.getUserEmail(), "Updating account at Pizza Palace", email.HTMLWraper(htmlBody));
		
		userLog.infoLogger("UserService: " + updatedUser.toString() + " updated.");
		return uRepo.findByUserName(updatedUser.getUserName());
	}
	
	public User getUserByName(String name) {
		userLog.infoLogger("UserService: getUserByName() invoked.");
		return uRepo.findByUserName(name);
	}
	
	public User getUserById(int id) {
		userLog.infoLogger("UserService: getUserById() invoked.");
		return uRepo.findByUserId(id);
	}
	
	public void deleteUser(User user) {
		userLog.infoLogger("UserService: deleteUser() invoked.");
		uRepo.delete(user);
		userLog.infoLogger("UserService: " + user.toString() + " deleted from DB.");
	}
	
	public User verifyPassword(User user) {
		userLog.infoLogger("UserService: verifyPassword() invoked.");
		User verifyUser = uRepo.findByUserName(user.getUserName());
		
		if (verifyUser == null) {
			userLog.errorLogger("UserService: There is no such user");
			return null;
		}
		
		if(!getEncrypteString(user.getUserPassword()).equals(verifyUser.getUserPassword())) {
			userLog.errorLogger("UserService: Passwords didn't matched");
			return null;
		}
		
		return verifyUser;
	}
	
	public String getEncrypteString(String str) {
		userLog.infoLogger("UserService: getEncrypteString() invoked.");
		return this.encr.generateSecurePassword(str, salt);
	}
	
}
