package com.food.Entity;

public class User {
	
	private String uname;
	private String mno;
	private String email;
	private String address;
	private String pass;
	private int id;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String uname, String mno, String email, String address) {
		super();
		this.uname = uname;
		this.mno = mno;
		this.email = email;
		this.address = address;
	}

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}
