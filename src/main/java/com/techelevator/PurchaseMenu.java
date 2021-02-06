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

	private void feedMoney() {
		String[] acceptableBills = { "1", "5", "10" };
		System.out.println("How much money would you like to input? ($1, $5, $10)");
		String moneyFed = this.getUserInput();

		if (moneyFed.equals(acceptableBills[0]) || moneyFed.equals(acceptableBills[1])
				|| moneyFed.equals(acceptableBills[2])) {
			Double startingBalance = currBalance;
			currBalance += Double.parseDouble(moneyFed);
			// Append to Log.txt moneyFed
			recordTransaction("Feed Money: " + startingBalance + " " + currBalance);
				
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
				Double startingBalance = currBalance;
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
				recordTransaction("Feed Money: " + startingBalance + " " + currBalance);
			} else {
				System.out.println("There is no " + selection + " slot.");
			}
		}
	}

	private void finalizeTransaction() {
		String change = "";
		Double startingBalance = currBalance;
		
		while (currBalance > 0.008) {
			if (currBalance >= 0.25) {
				change += (int) (currBalance / 0.25) + " quarters\n";
				currBalance -= (int) (currBalance / 0.25);
			} else if (currBalance >= 0.1) {
				change += (int) (currBalance / 0.1) + " dimes\n";
				currBalance -= (int) (currBalance / 0.25);
			} else if (currBalance >= 0.05) {
				change += (int) (currBalance / 0.05) + " nickels\n";
				currBalance -= (int) (currBalance / 0.25);
			} else if (currBalance >= 0.01) {
				change += (int) (currBalance / 0.01) + " pennies";
				currBalance -= (int) (currBalance / 0.25);
			}
		}

		System.out.println(change);
		// Log.txt
		recordTransaction("Feed Money: " + startingBalance + " " + currBalance);
	}

	private void recordTransaction(String transaction) {
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
