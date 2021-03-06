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
	private double totalSales = 0;
	private List<Item> inventory = new ArrayList<>();

	public PurchaseMenu(String[] options, List<Item> inventory) {
		super(options);
		this.inventory = inventory;
	}

	public double getCurrBalance() {
		return currBalance;
	}

	public void setCurrBalance(double amnt) {
		this.currBalance = amnt;
	}
	
	public double[] handleInput(String userIn) {

		if (userIn.equals("1")) { // feed money
			System.out.println("How much money would you like to input? ($1, $5, $10)");
			String moneyFed = this.getUserInput();
			
			feedMoney(moneyFed);
			
		} else if (userIn.equals("2")) { // select an item
//			// Print out inventory
//			for (Item item : inventory) {
//				System.out.println(item.getItemID() + ": " + item.getName() + "  $" + item.getPrice());
//			}

			System.out.print("\nEnter slot number (A1, B3, C2, etc): ");
			String selection = this.getUserInput();
			
			System.out.println(selectItem(selection));
			
		} else if (userIn.equals("3")) { // finalize transaction
			System.out.println(finalizeTransaction());
			return new double[] { 1, totalSales};
			
		} else {
			System.out.println("\nI don't recognize that selection!");
		}

		return new double[] { 0, totalSales };
	}

	public void feedMoney(String moneyFed) {
		if (moneyFed.equals("1") || moneyFed.equals("5") || moneyFed.equals("10")) {
			Double startingBalance = currBalance;
			currBalance += Double.parseDouble(moneyFed);
			// Append to Log.txt
			recordTransaction("Feed Money: " + startingBalance + " " + currBalance);

		} else {
			System.out.println("\nThat's not an acceptable amount.");
		}
	}

	public String selectItem(String userIn) {
		String output = "\n";
		int indexOfInput = -1;
		
		if (userIn == null) {
			return "\nYou didn't make a selection.\n";
		}
		
		userIn = userIn.toUpperCase();
		
		for (int i = 0; i < inventory.size(); i++) {//Iterating through
			if (inventory.get(i).getItemID().equals(userIn)) {
				indexOfInput = i;
				break;
			}
		}
		
		if (indexOfInput == -1) {//Question
			output += "There is no " + userIn + " slot.\n";
		} else {	
			String name = inventory.get(indexOfInput).getName();
			String ID = inventory.get(indexOfInput).getItemID();
			String type = inventory.get(indexOfInput).getType().toLowerCase();
			double price = inventory.get(indexOfInput).getPrice();
			double startingBalance = currBalance;
			int quantity = inventory.get(indexOfInput).getQuantity();
			
			
			
			if (quantity <= 0) {
				output += "Out of stock.\n";
			} else if (price > currBalance){
				output += "Insufficient funds.\n";
			} else if (userIn.isEmpty()) {//userIn.isBlank() || 
				output += "You didn't make a selection.\n";
			} else {
				System.out.println(name + " is $" + price + ", you have $"
						+ ((double) (((int)(currBalance * 1000) - (int)(price * 1000)) / 1000.0d)) + " left.\n");
	
				switch (type) {
				case "chips":
					output += "Crunch Crunch, Yum!\n";
					break;
				case "candy":
					output += "Munch Munch, Yum!\n";
					break;
				case "drink":
					output += "Glug Glug, Yum!\n";
					break;
				case "gum":
					output += "Chew Chew, Yum!\n";
					break;
				}
				
				currBalance = (double) (((int)(currBalance * 1000) - (int)(price * 1000)) / 1000.0d);
				totalSales += price;
				inventory.get(indexOfInput).setQuantity();
				SalesReport.setLogList(name);
			}
			
			
			// append to Log.txt
			recordTransaction(name + " " + type + ": " + startingBalance + " " + currBalance);
		}
		
		return output;
	}

	public String finalizeTransaction() {
		String numOfCoins = "";
		Double startingBalance = currBalance;
		int ammountOfCoins = 0;

		while (currBalance > 0.008) {
			if (currBalance >= 0.25) {
				numOfCoins += (int) (currBalance / 0.25) + " quarter(s)\n";
				ammountOfCoins = (int) (currBalance / 0.25) * 25;
			} else if (currBalance >= 0.1) {
				numOfCoins += (int) (currBalance / 0.1) + " dime(s)\n";
				ammountOfCoins = (int) (currBalance / 0.1) * 10;
			} else if (currBalance >= 0.05) {
				numOfCoins += (int) (currBalance / 0.05) + " nickel(s)\n";
				ammountOfCoins = (int) (currBalance / 0.05) * 5;
			} else if (currBalance >= 0.01) {
				numOfCoins += (int) (currBalance / 0.01) + " pennie(s)";
				ammountOfCoins = (int) (currBalance / 0.01) * 1;
			}
			
			currBalance = ((int) (currBalance * 100) - ammountOfCoins) / 100.0;
		}
		currBalance = 0;
		// append to Log.txt
		recordTransaction("GIVE CHANGE: " + "$" + startingBalance + " $" + 0.00);

		return ("Your change is: " + numOfCoins);
	}

	public void recordTransaction(String transaction) {
		File log = new File("Log.txt");
		Date date = new Date();//Question
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");//Question

		try (FileWriter logWriter = new FileWriter(log, true)) {//Append file, don't replace
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
