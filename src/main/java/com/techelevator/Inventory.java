package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

	
	private String[] itemList= null;
	private List <Item> inventory = new ArrayList<>(); 

	
	
	public Inventory() {
		parseItemFile();
	}
	
	public String[] parseItemFile() {
		String [] itemDetails = null;
		File vendingMachineCSV = new File ("vendingmachine.csv"); 
		
		try(Scanner opensVendingMachineCSV = new Scanner (vendingMachineCSV)){
		
			
			while (opensVendingMachineCSV.hasNext()){
					String thisLine = opensVendingMachineCSV.nextLine();
							itemDetails = thisLine.split("\\|");
					Item newItem = new Item (itemDetails[0], itemDetails[1], itemDetails[2], itemDetails[3]);
					inventory.add(newItem); 
					
			}
			
		} catch (FileNotFoundException e){
			System.out.println("FileNotFound");
		}
		
		return itemDetails;
	}

	public List<Item> getInventory() {
		return inventory;
	}
	
	
	

	
}
