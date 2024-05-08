package com.food.Entity;

public class DeliveryBoy {
	
	private String name;
	private String phno;
	private String address;
	private String email;
	private String pass;
	private int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DeliveryBoy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeliveryBoy(String name, String phno, String address) {
		super();
		this.name = name;
		this.phno = phno;
		this.address = address;
	}
	
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
