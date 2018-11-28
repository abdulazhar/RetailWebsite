package com.retail.website;

/*
 * File Name : Cart.java
 * Description : Defined the Cart class with proper functionalities
 * Version     Name                 Date       Comments
 * 1.0       Abdul Azhardueen K    28/11/18    Initial Version
 */

import java.util.LinkedList;
import java.util.List;

public class Cart {

	List<Item> items;

	public Cart() {
		items = new LinkedList<Item>();
	}

	// Method is used to add/upadte the item to the cart
	public void addItem(Item item) throws Exception {

		Item updateItem = null;
		int flag = 0;
		for (Item tempItem : items) {
			updateItem = (Item) tempItem;
			if (tempItem.getName().equalsIgnoreCase(item.getName())) {
				flag = 1;
				items.remove(tempItem);
				break;
			}
		}

		if (flag == 1) {
			updateItem.setQuantity(updateItem.getQuantity() + 1);
			items.add(updateItem);
			System.out.println("Item is added to the cart");

		} else {
			items.add(item);
			System.out.println("Item is added to the card");
		}
	}

	// Method is used to remove the item from the cart
	public void removeItem(String name) throws Exception {

		Item updateItem = null;
		int flag = 0;
		for (Item tempItem : items) {
			updateItem = (Item) tempItem;
			if (tempItem.getName().equalsIgnoreCase(name)) {
				flag = 1;
				items.remove(tempItem);
				System.out.println("Item is removed from the cart");
				break;
			}
		}

		if (flag == 1 && updateItem.getQuantity() != 1) {
			updateItem.setQuantity(updateItem.getQuantity() - 1);
			items.add(updateItem);
			System.out.println("Item is removed successfully");
		}

		else if(flag == 0)
			System.out.println(name + " is not found in the cart");
		;
	}

	// Method is used to get the total discounted bill amount
	public double getBill(String custType, int custYears) throws Exception {
		double totalBill = 0.0d;
		double groBill = 0.0d;
		for (Item tempItem : items) {
			if (tempItem.getType().equals("GROCERIES"))
				groBill += tempItem.getPrice() * tempItem.getQuantity();
			else
				totalBill += tempItem.getPrice() * tempItem.getQuantity();
		}
		if (custType.equalsIgnoreCase("Employee"))
			totalBill = totalBill - (totalBill * (30.0 / 100.0)); // Reduce the 30 percentage of bill for custormer who is Employee
															
		else if (custType.equalsIgnoreCase("Affiliate"))
			totalBill = totalBill - (totalBill * (10.0 / 100.0)); // Reduce the 10 percentage of bill for custormer who is Affiliate
																	
		else if (custType.equalsIgnoreCase("Customer") && custYears >= 2)
			totalBill = totalBill - (totalBill * (5.0 / 100.0)); // Reduce the 5 percentage of bill for custormer who is having 2 or more years relationship
																

		totalBill = totalBill + groBill;

		totalBill = totalBill - ((totalBill / 100) * 5); // Reduce the 5 dollars for per 100 dollars including groceries

		return totalBill;
	}

	public void displayCart() {
		System.out
				.println("------------------------Shopping Cart------------------------------------------");
		System.out.println("ItemName		ItemType		Price		Quantity");
		if (items.isEmpty())
			System.out.println("OOPS! Cart is Empty");
		for (Item tempItem : items) {
			System.out.println(tempItem.getName() + "		    "
					+ tempItem.getType() + "		   " + tempItem.getPrice()
					+ "		   " + tempItem.getQuantity());

		}
		System.out
				.println("------------------------------------------------------------------");
	}
}
