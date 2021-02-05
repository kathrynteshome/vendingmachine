package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Item {

	private String itemID = "";
	private String name = "";
	private double price;
	private String type = "";
	private int quantity = 5;
	
	public Item(String itemID, String name, String price, String type) {
		this.itemID = itemID;
		this.name = name;
		this.price = Double.parseDouble(price);
		this.type = type;
		
	}
	
	public int getQuantity() {	
		return quantity;
	}
	
	public int setQuantity(int quantity) {
		return this.quantity = quantity - 1;
	}
	
	public String getItemID() {
		return itemID;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getType() {
		return type;
	}
	
	


}
