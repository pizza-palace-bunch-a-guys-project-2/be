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
	//@OneToMany(mappedBy="userId")
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
	
	@Column(name="user_address")
	private String userAddress;
	
	@Column(name="user_city")
	private String userCity;
	
	@Column(name="user_state")
	private String userState;
	
	@Column(name="user_zip")
	private String userZip;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public User(int userId, String userName, String userPassword, String userEmail, String userFirstName,
			String userLastName, String userAddress, String userCity, String userState, String userZip) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userAddress = userAddress;
		this.userCity = userCity;
		this.userState = userState;
		this.userZip = userZip;
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

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserZip() {
		return userZip;
	}

	public void setUserZip(String userZip) {
		this.userZip = userZip;
	}
	
	@Override
	public String toString() {
		String result = "User with [";
		if(userId != 0) {
			result += "Id: " + userId + ", ";
		}
		result += "User Name: " + userName + ", " + "Password: " + userPassword + ", ";
		if(userEmail != null) {
			result += "Email: " + userEmail + ", ";
		}
		if(userFirstName != null) {
			result += "First Name: " + userFirstName + ", ";
		}
		if(userLastName != null) {
			result += "Last Name: " + userLastName + ", ";
		}
		if(userAddress != null) {
			result += "Address: " + userAddress + ", ";
		}
		if(userCity != null) {
			result += "City: " + userCity + ", ";
		}
		if(userState != null) {
			result += "State: " + userState + ", ";
		}
		if(userZip != null) {
			result += "Zip: " + userZip + ", ";
		}
		result = result.substring(0, (result.length() - 2));
		
		return result + "] ";
	}
}
