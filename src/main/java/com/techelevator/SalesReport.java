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

	private Map<String, Integer> logList = new HashMap<>();
	private int count = 0;
	private List<Item> inventory = new ArrayList<>();

	
	public SalesReport(List<Item> inventory) {
		this.inventory = inventory;
	}
	
	public void makeSalesReport(Map<String, Integer> logList) {
		File sales = new File("SalesReport.txt");

		try (FileWriter salesWriter = new FileWriter(sales, true)) {//Append file, don't replace
			if (!sales.exists()) {
				sales.createNewFile();
			}
			try (PrintWriter writer = new PrintWriter(salesWriter)) {
				for (String item : logList.keySet()) {
					
					writer.print(item + "|" + logList.get(item));
				}
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

	public void setLogList(String name) {
		int value = logList.get(name) + 1;
		value++;
		logList.replace(name, value);
	}
	
	
}
