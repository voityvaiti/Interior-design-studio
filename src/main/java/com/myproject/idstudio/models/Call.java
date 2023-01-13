package com.myproject.idstudio.models;



import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;


public class Call {
	private int id;
	@NotBlank(message = "Please, enter your name")
	@Size(max = 40, message = "Too long name!")
	private String name;
	@NotBlank(message = "Please, enter your telephone number")
	@Size(max = 16, message = "Too long telephone number!")
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
