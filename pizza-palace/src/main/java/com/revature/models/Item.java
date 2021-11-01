package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemId;
	
//	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinColumn(name="type_fk")
	@Column(name="type")
	private String type;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="price")
	private float price;
	
	@Column(name="img_url")
	private String imageURL;
	
	@Column(name="description")
	private String description;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(int itemId, String type, String itemName, float price, String imageURL, String description) {
		super();
		this.itemId = itemId;
		this.type = type;
		this.itemName = itemName;
		this.price = price;
		this.imageURL = imageURL;
		this.description = description;
	}
	
	public Item(String type, String itemName, float price, String imageURL, String description) {
		super();
		this.type = type;
		this.itemName = itemName;
		this.price = price;
		this.imageURL = imageURL;
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String name) {
		this.itemName = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getItemId() {
		return itemId;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", type=" + type + ", name=" + itemName + ", price=" + price + ", imageURL="
				+ imageURL + ", description=" + description + "]";
	}
}
