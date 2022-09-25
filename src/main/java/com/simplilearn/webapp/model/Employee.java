package com.simplilearn.webapp.model;

import java.util.Date;

public class Employee {

	// properties id,nme,email,password,country
	private int id;
	private String name;
	private String email;
	private String password;
	private String country;
	
	// constructor
	public Employee() {}
	
	public Employee(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Employee(int id, String name, String email, String password, String country) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.country = country;
	}
	
	public Employee(String name, String email, String password, String country) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.country = country;
	}
	
	
	
	
	
	
	

}