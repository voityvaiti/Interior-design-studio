package com.myproject.idstudio.models;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
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
