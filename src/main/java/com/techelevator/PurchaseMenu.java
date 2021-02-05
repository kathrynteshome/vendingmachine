package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class PurchaseMenu extends Menu{
	
	private double currMoneyProvided = 0;
	private List<Item> inventory = new ArrayList<>();
	
	public PurchaseMenu(String[] options, List<Item> inventory) {
		super(options);
		this.inventory = inventory;
	}
	
	public boolean handleInput(String userIn) {
		
		if (userIn.equals("1")) { // feed money
			feedMoney();
			
		} else if (userIn.equals("2")) { // select an item
			
			// Print out inventory
			for (Item item : inventory) {
				System.out.println(item.getItemID() + ": " + item.getName() + "  $" + item.getPrice());
			}
			
			System.out.print("Enter slot number (A1, B3, C2, etc): ");
			String selection = this.getUserInput();
			
			for (Item item : inventory) {
				if (item.getItemID().equals(selection) && item.getQuantity() > 0) {
					/*
					 * display item name
					 * display item cost
					 * display currmoney - item cost
					 * display message for item type (readme at 7.2)
					 * currmoney -= item cost
					 * append to Log.txt
					 */
				}
			}
			
		} else if (userIn.equals("3")) { // finalize transaction
			/*
			 * display change given
			 *     in quarters, dimes, nickels, and pennies
			 *     use smallest amount possible (0.55 => 2 quarters, 1 nickel)
			 * currmoney = 0;
			 * append to Log.txt
			 */
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
		
		if (moneyFed.equals(acceptableBills[0]) || moneyFed.equals(acceptableBills[1]) || moneyFed.equals(acceptableBills[2])) {
			currMoneyProvided += Double.parseDouble(moneyFed);
			// Append to Log.txt moneyFed
		} else {
			System.out.println("That's not an acceptable ammount.");
		}
	}

}
