package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import org.junit.Assert;

public class SalesReportTest {

	@Test
	public void does_sales_report_get_written() {
		// Arrange
		List<Item> inventory = new ArrayList<>();
		Item testItemClass1 = new Item("A1", "Potato Crisps", "3.05", "Chips");
		Item testItemClass2 = new Item("D2", "Little League Chew", "0.95", "Gum");
		inventory.add(testItemClass1);
		inventory.add(testItemClass2);
		SalesReport sr = new SalesReport(inventory);
		SalesReport.setLogList("Potato Crisps");
		sr.makeSalesReport(3.05);
		
		// Act
		File dataFile = new File("SalesReport.txt");
		boolean actual = dataFile.exists();
		boolean actual2 = false;		
		try ( Scanner openFile = new Scanner(dataFile)){
			//Act
				
				while (openFile.hasNextLine()){
					String thisLine = openFile.nextLine();

					if (thisLine.contains("Potato Crisps|1")){//Looks at last line of log
						actual2 = true;
					}
				
				
			}
					
			} catch (Exception e) {
				System.out.println("File not found.");
			}
		
		
		// Assert
		Assert.assertEquals(true, actual);
		Assert.assertEquals(true, actual2);
	}
	
	
}
