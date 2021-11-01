package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Entity
//@Table(name="type")
public class Type {
	
//	@Id
//	@Column(name="type_id")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int typeId;
	
	//@OneToOne(mappedBy="type", fetch=FetchType.EAGER)
	private String type;
	
	public Type() {
		// TODO Auto-generated constructor stub
	}
	
	public Type(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}
	
	public Type(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTypeId() {
		return typeId;
	}

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", type=" + type + "]";
	}
}
