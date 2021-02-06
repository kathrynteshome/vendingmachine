package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	public void feedMoney() {
		System.out.println("How much money would you like to input? ($1, $5, $10)");
		String moneyFed = this.getUserInput();

		if (moneyFed.equals("1") || moneyFed.equals("5")
				|| moneyFed.equals("10")) {
			Double startingBalance = currBalance;
			currBalance += Double.parseDouble(moneyFed);
			// Append to Log.txt moneyFed
			recordTransaction("Feed Money: " + startingBalance + " " + currBalance);
				
		} else {
			System.out.println("That's not an acceptable ammount.");
		}
	}

	public String selectItem() {
		String returnString = "";
		
		// Print out inventory
		for (Item item : inventory) {
			System.out.println(item.getItemID() + ": " + item.getName() + "  $" + item.getPrice());
		}

		System.out.print("Enter slot number (A1, B3, C2, etc): ");
		String selection = this.getUserInput();

		for (Item item : inventory) {
			if (item.getItemID().equals(selection) && item.getQuantity() > 0 && item.getPrice() < currBalance) {
				Double startingBalance = currBalance;
				System.out.println(item.getName() + " is " + item.getPrice() + ", you have "
						+ (currBalance - item.getPrice()) + " left.");
				
				switch (item.getType().toLowerCase()) {
				case "chip":
					returnString += ("Crunch Crunch, Yum!");
					break;
				case "candy":
					returnString += ("Munch Munch, Yum!");
					break;
				case "drink":
					returnString += ("Glug Glug, Yum!");
					break;
				case "gum":
					returnString += ("Chew Chew, Yum!");
					break;
				}

				currBalance -= item.getPrice();
				item.setQuantity();
				// append to Log.txt
				recordTransaction(item.getName() + " " + item.getType() + ": " + startingBalance + " " + currBalance);
			} else if (!item.getItemID().equals(selection)){
				returnString += ("There is no " + selection + " slot.");
			} else if (item.getQuantity() <= 0) {
				returnString += ("Out of stock.");
			} else {
				returnString += ("Insufficient funds.");
			}
		}
		
		return returnString;
	}

	public String finalizeTransaction() {
		String numOfCoins = "";
		Double startingBalance = currBalance;
		
		while (currBalance > 0.008) {
			if (currBalance >= 0.25) {
				numOfCoins += (int) (currBalance / 0.25) + " quarter(s)\n";
				currBalance -= (currBalance - (currBalance % 0.25));
			} else if (currBalance >= 0.1) {
				numOfCoins += (int) (currBalance / 0.1) + " dime(s)\n";
				currBalance -= (currBalance / 0.25);
			} else if (currBalance >= 0.05) {
				numOfCoins += (int) (currBalance / 0.05) + " nickel(s)\n";
				currBalance -= (currBalance / 0.25);
			} else if (currBalance >= 0.01) {
				numOfCoins += (int) (currBalance / 0.01) + " pennie(s)";
				currBalance -= (currBalance / 0.25);
			}
		}
		
		// append to Log.txt
		recordTransaction("GIVE CHANGE: " + "$" +startingBalance + " $" + 0.00);

		return ("Your change is: " + numOfCoins);
	}

	public void recordTransaction(String transaction) {
		File log = new File("Log.txt");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		try (FileWriter logWriter = new FileWriter(log, true)){						
			if (!log.exists()) {
				log.createNewFile();
			}
			try (PrintWriter writer = new PrintWriter(logWriter)) {
					writer.print("> " + formatter.format(date) + " " + transaction + "\n");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
