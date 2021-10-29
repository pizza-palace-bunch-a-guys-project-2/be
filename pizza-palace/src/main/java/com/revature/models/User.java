package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@Column(name="user_name", unique=true, nullable=false)
	private String userName;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_first_name")
	private String userFirstName;
	
	@Column(name="user_last_name")
	private String userLastName;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public User(String userName, String userPassword, String userEmail, String userFirstName, String userLastName) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
	}
	

	public User(int userId, String userName, String userPassword, String userEmail, String userFirstName,
			String userLastName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + "]";
	}
	
}
