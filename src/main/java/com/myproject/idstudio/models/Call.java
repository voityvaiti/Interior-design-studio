package com.myproject.idstudio.models;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Call {
	private int id;
	@NotBlank(message = "Enter your name")
	@Size(max = 20, message = "Too long name")
	@Pattern(regexp = "^[A-Za-z][A-Za-z .'\\-]{1,}|^$|.{21,}", message = "Invalid name")
	private String name;
	@NotBlank(message = "Enter your telephone number")
	@Size(max = 16, message = "Too long telephone number")
	@Pattern(regexp = "^\\+[0-9]{7,}|^$|.{17,}", message = "Invalid telephone number")
	private String number;
	
	public Call(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	public Call(int id, String name, String number) {
		this.id = id;
		this.name = name;
		this.number = number;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
