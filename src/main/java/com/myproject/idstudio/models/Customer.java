package com.myproject.idstudio.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	private int id;
	@NotBlank(message = "Please, enter your first name")
	@Size(max = 20, message = "Too long first name")
	@Pattern(regexp = "^[A-Za-z][A-Za-z .'\\-]{1,}|^$|.{21,}", message = "Invalid first name")
	private String firstName;
	@NotBlank(message = "Please, enter your last name")
	@Size(max = 20, message = "Too long last name")
	@Pattern(regexp = "^[A-Za-z][A-Za-z .'\\-]{1,}|^$|.{21,}", message = "Invalid last name")
	private String lastName;
	@NotBlank(message = "Please, enter your telephone number")
	@Size(max = 16, message = "Too long telephone number")
	@Pattern(regexp = "^\\+[0-9]{7,}|^$|.{17,}", message = "Invalid telephone number")
	private String telNumber;
	
	public Customer(String firstName, String lastName, String telNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.telNumber = telNumber;
	}

	public Customer(int id, String firstName, String lastName, String telNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telNumber = telNumber;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + ", " + telNumber;
	}
}
