package com.revature.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	
	@Column(name="item_list")
	private String items;
	
	@Column(name="payment_details")
	private String paymentDetails;
	
	@Column(name="total")
	private float total;
	
	@Column(name="address")
	private String address;
	
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//@JoinColumn(name = "user_fk")
	@Column(name="user_id")
	private int userId;
	
	public Order() {}

	public Order(int orderId, String items, String paymentDetails, String address, float total, int userId) {
		super();
		this.orderId = orderId;
		this.items = items;
		this.paymentDetails = paymentDetails;
		this.total = total;
		this.userId = userId;
		this.address=address;
	}
	public Order(String items, String paymentDetails, String address, float total, int userId) {
		super();
		this.items = items;
		this.paymentDetails = paymentDetails;
		this.address=address;
		this.total = total;
		this.userId = userId;
	}

	public Order(String items, String paymentDetails, String address, float total) {
		super();
		this.items = items;
		this.paymentDetails = paymentDetails;
		this.address=address;
		this.total = total;
		
	}
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId=userId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", items=" + items + ", paymentDetails=" + paymentDetails
				+ ", total=" + total + ", address=" + address + ", userId=" + userId + "]";
	}
	
	 
	public String toStringEmail() {
		return "Pizza Palace Order Confirmation\n Your Order Id is: " + orderId + ". " 
				+ "\nYour pizza will be delivered to " + address + ". " + "\nYour total is " + total +". " 
				+ "\nYour order should contain " + items + ".";
	}
}
