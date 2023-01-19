package com.myproject.idstudio.models;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Call {
	private int id;
	private int customerId;
	@NotBlank(message = "Field of name is empty")
	@Size(max = 20, message = "Too long name")
	@Pattern(regexp = "^[A-Za-z][A-Za-z .'\\-]{1,}|^$|.{21,}", message = "Invalid name")
	private String name;
	@NotBlank(message = "Field of telephone number is empty")
	@Size(max = 16, message = "Too long telephone number")
	@Pattern(regexp = "^\\+[0-9]{7,}|^$|.{17,}", message = "Invalid telephone number")
	private String number;
	
	public Call(String name, String number) {
		this.name = name;
		this.number = number;
	}
	public Call(int id, int customerId, String name, String number) {
		this.id = id;
		this.customerId = customerId;
		this.name = name;
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return name + ", " + number;
	}

}
