package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Item {

	private String itemID = "";
	private String name = "";
	private String type = "";
	private double price;
	private int quantity = 5;
	
	public Item() {
		this.itemID = itemID;
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String[] parseItemFile() {
		String [] itemDetails = null;
		File vendingMachineCSV = new File ("vendingmachine.csv"); 
		
		try(Scanner opensVendingMachineCSV = new Scanner (vendingMachineCSV)){
		
			if (opensVendingMachineCSV.hasNext()) {
				String thisLine = opensVendingMachineCSV.nextLine();
				itemDetails = thisLine.split("\\|");
				
			}
		} catch (FileNotFoundException e){
			System.out.println("FileNotFound");
		}
		
		return itemDetails;
	}
	
	public int getQuantity() {
		
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity - 1;
	}
	
	public String getItemID() {
		
		itemID = itemDetails[0];
		
		return itemID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public double getPrice() {
		return price;
	}


}
