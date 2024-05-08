package com.food.Entity;

public class Restorunt {
	
	public Restorunt() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String rname;
	private String address;
	private String rno;
	private int rid;
	private String email;
	private String pass;
	
	
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

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	
	
	public Restorunt(String rname, String address, String rno) {
		super();
		this.rname = rname;
		this.address = address;
		this.rno = rno;
	}

	public String getRname() {
		return rname;
	}
	
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	

}
