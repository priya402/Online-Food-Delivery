package com.food.Entity;

public class MenuItem {

	private int id;
	private String price;
	private String name;
	private int resto_id;
	private String description;
	private String type;
	private int discount;
	
	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	private String image;
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getResto_id() {
		return resto_id;
	}

	public void setResto_id(int i) {
		this.resto_id = i;
	}

	public MenuItem(int id, String price, String name) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
	}

	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
