package com.retail.website;

/*
 * File Name : Item.java
 * Description : Defined the POJO class for the Item/product
 * Version     Name                 Date       Comments
 * 1.0       Abdul Azhardueen K    28/11/18    Initial Version
 */

public class Item {
    //Variable Declaration 
	private String name;
	private double price;
	private ItemTypes type;
	private int quantity;

	public Item() {

	}
    
	public Item(String name, double price, ItemTypes type, int quantity) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ItemTypes getType() {
		return type;
	}

	public void setType(ItemTypes type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
