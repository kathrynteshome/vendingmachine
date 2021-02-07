package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SalesReport {

	private static Map<String, Integer> logList = new HashMap<>();
	private int count = 0;
	private List<Item> inventory = new ArrayList<>();

	
	public SalesReport(List<Item> inventory) {
		this.inventory = inventory;
		makeHashMap();
	}
	
	public void makeSalesReport(double amnt) {
		File sales = new File("SalesReport.txt");

		try (FileWriter salesWriter = new FileWriter(sales, true)) {//Append file, don't replace
			if (!sales.exists()) {
				sales.createNewFile();
			}
			try (PrintWriter writer = new PrintWriter(salesWriter)) {
				for (String item : logList.keySet()) {
					
					writer.print(item + "|" + logList.get(item) + "\n");
				}
				
				writer.print("TOTAL SALES|" + amnt);
			}
		} catch (Exception e) {
			System.out.println("No file found.");
		}
	}
	
	
	public void makeHashMap() {
		for (int i = 0; i < inventory.size(); i++) {//Iterating through
			logList.put(inventory.get(i).getName(), 0);
				
		}
		
	}

	public static void setLogList(String name) {
		int value = logList.get(name);
		value++;
		logList.replace(name, value);
	}
	
	
}
