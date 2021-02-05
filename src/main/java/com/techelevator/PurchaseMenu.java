package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class PurchaseMenu extends Menu {

	private double currBalance = 0;
	private List<Item> inventory = new ArrayList<>();

	public PurchaseMenu(String[] options, List<Item> inventory) {
		super(options);
		this.inventory = inventory;
	}

	public boolean handleInput(String userIn) {

		if (userIn.equals("1")) { // feed money
			feedMoney();

		} else if (userIn.equals("2")) { // select an item
			selectItem();
			
		} else if (userIn.equals("3")) { // finalize transaction			
			finalizeTransaction();
			return true;
		} else {
			System.out.println("I don't recognize that selection?");
		}

		return false;
	}

	private void feedMoney() {
		String[] acceptableBills = { "1", "5", "10" };
		System.out.println("How much money would you like to input? ($1, $5, $10)");
		String moneyFed = this.getUserInput();

		if (moneyFed.equals(acceptableBills[0]) || moneyFed.equals(acceptableBills[1])
				|| moneyFed.equals(acceptableBills[2])) {
			currBalance += Double.parseDouble(moneyFed);
			// Append to Log.txt moneyFed
		} else {
			System.out.println("That's not an acceptable ammount.");
		}
	}

	private void selectItem() {
		// Print out inventory
		for (Item item : inventory) {
			System.out.println(item.getItemID() + ": " + item.getName() + "  $" + item.getPrice());
		}

		System.out.print("Enter slot number (A1, B3, C2, etc): ");
		String selection = this.getUserInput();

		for (Item item : inventory) {
			if (item.getItemID().equals(selection) && item.getQuantity() > 0) {
				System.out.println(item.getName() + " is " + item.getPrice() + ", you have "
						+ (currBalance - item.getPrice()) + " left.");
				switch (item.getType()) {
				case "chip":
					System.out.println("Crunch Crunch, Yum!");
					break;
				case "candy":
					System.out.println("Munch Munch, Yum!");
					break;
				case "drink":
					System.out.println("Glug Glug, Yum!");
					break;
				case "gum":
					System.out.println("Chew Chew, Yum!");
					break;
				}

				currBalance -= item.getPrice();
				// append to Log.txt
			} else {
				System.out.println("There is no " + selection + " slot.");
			}
		}
	}
	
	private void finalizeTransaction() {
		String change = "";
		
		while (currBalance > 0.008) {
			if (currBalance >= 0.25) {
				change += (int)(currBalance / 0.25) + " quarters\n";
				currBalance -= (int)(currBalance / 0.25);
			} else if (currBalance >= 0.1) {
				change += (int)(currBalance / 0.1) + " dimes\n";
				currBalance -= (int)(currBalance / 0.25);
			} else if (currBalance >= 0.05) {
				change += (int)(currBalance / 0.05) + " nickels\n";
				currBalance -= (int)(currBalance / 0.25);
			} else if (currBalance >= 0.01) {
				change += (int)(currBalance / 0.01) + " pennies";
				currBalance -= (int)(currBalance / 0.25);
			}
		}
		
		System.out.println(change);
		// Log.txt
	}

}
