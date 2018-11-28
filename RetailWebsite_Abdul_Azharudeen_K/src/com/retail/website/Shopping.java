package com.retail.website;

/*
 * File Name : Shopping.java
 * Description : This class will act as a driver class for retail shopping
 * Version     Name                 Date       Comments
 * 1.0       Abdul Azhardueen K    28/11/18    Initial Version
 */

import java.util.Scanner;

public class Shopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner s = new Scanner(System.in);
			Cart cart = new Cart();
			System.out.println("Enter the customer name :");
			String custName = s.next().trim();
			System.out
					.println("Enter the customer type: \n Employee \n Affiliate \n Customer");
			String custType = s.next().trim();
			System.out
					.println("Enter the customer membership in years(no floating value):");
			int custYears = s.nextInt();

			int flag = 0;
			do {

				System.out
						.println("Enter the Purchase option: \n 1.Add Item \n 2.Remove Item \n 3.Get the bill \n 4.Display the Cart \n 5.Exit");
				flag = s.nextInt();
				switch (flag) {
				case 1:
					Item item = new Item();
					System.out.println("Enter the Item name:");
					item.setName(s.next().trim());
					System.out
							.println("Enter the Item type: \n GROCERIES \n LAPTOP \n MOBILE");
					String itemType = s.next().trim();
					if (itemType.equalsIgnoreCase("GROCERIES"))
						item.setType(ItemTypes.GROCERIES);
					else if (itemType.equalsIgnoreCase("LAPTOP"))
						item.setType(ItemTypes.LAPTOP);
					else if (itemType.equalsIgnoreCase("MOBILE"))
						item.setType(ItemTypes.MOBILE);
					else {
						System.out.println("OOPS!!!Invalid Item Type");
						System.out.println("Item is not added to the cart");
						break;
					}
					System.out.println("Enter the Price:");
					item.setPrice(s.nextDouble());
					item.setQuantity(1);
					cart.addItem(item);
					break;
				case 2:
					System.out.println("Enter the Item name to remove :");
					cart.removeItem(s.next().trim());

					break;
				case 3:
					double bill = cart.getBill(custType, custYears);
					System.out.println("Total Bill is " + bill);
					break;
				case 4:
					cart.displayCart();
					break;
				case 5:
					System.out.println("Shpping Over. Welcome Again");
					break;
				default:
					System.out
							.println("Invalid Option - Select the appropriate option");
					break;

				}

			} while (flag != 5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}