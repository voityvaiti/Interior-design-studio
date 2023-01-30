package com.myproject.idstudio.models;

public class Call {
	private int id;
	private Customer customer;
	
	public Call(Customer customer) {
		this.customer = customer;
	}
	public Call(int id, Customer customer) {
		this.id = id;
		this.customer = customer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return customer.getFirstName() + ", " + customer.getTelNumber();
	}

}
