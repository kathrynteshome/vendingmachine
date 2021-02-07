package com.techelevator;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;

public class PurchaseMenuTest {

	@Test
	public void minimal_change_test() {

		// Arrange
		String[] testStringArray = { "Feed Money", "Select Product", "Finish Transaction" };
		List<Item> inventory = new ArrayList<>();
		Item testItemClass1 = new Item("A1", "Potato Crisps", "3.05", "Chips");
		Item testItemClass2 = new Item("D2", "Little League Chew", "0.95", "Gum");
		inventory.add(testItemClass1);
		inventory.add(testItemClass2);
		PurchaseMenu test = new PurchaseMenu(testStringArray, inventory);

		// Act
		test.setCurrBalance(6.89);
		String expectation = "Your change is: 27 quarter(s)\n1 dime(s)\n4 pennie(s)";
		String reality = test.finalizeTransaction();

		// Assert
		Assert.assertEquals(expectation, reality);
	}
	// check current balance for each of the methods

	@Test
	public void feedMoney_takes_proper_amount_and_adds_to_currentBalance() {
		// Arrange
		String[] testStringArray = { "Feed Money", "Select Product", "Finish Transaction" };
		List<Item> inventory = new ArrayList<>();
		PurchaseMenu test = new PurchaseMenu(testStringArray, inventory);
		String amntToAdd1 = "5";
		String amntToAdd2 = "10";
		String amntToAdd3 = "1";
		String amntToAdd4 = "6.5";

		// Act
		test.feedMoney(amntToAdd1);
		boolean added1 = test.getCurrBalance() == 5.0;
		test.feedMoney(amntToAdd2);
		boolean added2 = test.getCurrBalance() == 15.0;
		test.feedMoney(amntToAdd3);
		boolean added3 = test.getCurrBalance() == 16.0;
		test.feedMoney(amntToAdd4);
		boolean added4 = test.getCurrBalance() == 16.0;

		// Assert
		Assert.assertEquals(true, added1);
		Assert.assertEquals(true, added2);
		Assert.assertEquals(true, added3);
		Assert.assertEquals(true, added4);
	}

	@Test
	public void selectItem_returns_expected_string() {
		// Arrange
		String[] testStringArray = { "Feed Money", "Select Product", "Finish Transaction" };
		List<Item> inventory = new ArrayList<>();
		Item testItemClass1 = new Item("A1", "Potato Crisps", "3.05", "Chips");
		Item testItemClass2 = new Item("A2", "Potato Crisps", "1.00", "Chips");
		Item testItemClass3 = new Item("D2", "Little League Chew", "0.95", "Gum");
		inventory.add(testItemClass1);
		inventory.add(testItemClass2);
		inventory.add(testItemClass3);
		PurchaseMenu test = new PurchaseMenu(testStringArray, inventory);
		test.setCurrBalance(1.00);
		
		for (int i = 0; i < 5; i++) {
			testItemClass3.setQuantity();
		}
		
		// Act
		String testCase1 = test.selectItem("A1");
		String testCase2 = test.selectItem("A2");
		String testCase3 = test.selectItem("D2");
		String testCase4 = test.selectItem("B2");
		String testCase5 = test.selectItem(null);
		
		// Assert
		Assert.assertEquals("Insufficient funds.", testCase1);
		Assert.assertEquals("Crunch Crunch, Yum!", testCase2);
		Assert.assertEquals("Out of stock.", testCase3);
		Assert.assertEquals("There is no B2 slot.", testCase4);
		Assert.assertEquals("You didn't make a selection.", testCase5);
	}

	@Test
	public void does_it_update_inventory_class_when_item_is_purchased() {
		//Arrange
		String[] testStringArray = { "Feed Money", "Select Product", "Finish Transaction" };
		List<Item> inventory = new ArrayList<>();
		Item testItemClass1 = new Item("A1", "Potato Crisps", "3.05", "Chips");
		Item testItemClass2 = new Item("A2", "Potato Crisps", "1.00", "Chips");
		Item testItemClass3 = new Item("D2", "Little League Chew", "0.95", "Gum");
		inventory.add(testItemClass1);
		inventory.add(testItemClass2);
		inventory.add(testItemClass3);
		PurchaseMenu test = new PurchaseMenu(testStringArray, inventory);

		for (int i = 0; i < 4; i++) {
			testItemClass2.setQuantity();
		}
		
		for (int i = 0; i < 5; i++) {
			testItemClass3.setQuantity();
		}
		
		int expected2 = 1;
		int actual2 = testItemClass2.getQuantity();
		int expected3 = 0;
		int actual3 = testItemClass3.getQuantity();
		
		Assert.assertEquals(expected2, actual2);
		Assert.assertEquals(expected3, actual3);
	}
	
	@Test
	public void does_it_append_file() {
		//Arrange
		String[] testStringArray = { "Feed Money", "Select Product", "Finish Transaction" };
		List<Item> inventory = new ArrayList<>();
		Item testItemClass1 = new Item("A1", "Potato Crisps", "3.05", "Chips");
		Item testItemClass3 = new Item("D2", "Little League Chew", "0.95", "Gum");
		inventory.add(testItemClass1);
		inventory.add(testItemClass3);
		PurchaseMenu test = new PurchaseMenu(testStringArray, inventory);
		test.feedMoney("5.00");
		test.selectItem("A1");
		boolean actual = false;
		//Assert
		File dataFile = new File("Log.txt");
		try ( Scanner openFile = new Scanner(dataFile)){
		//Act
			
			while (openFile.hasNextLine()){
				String thisLine = openFile.nextLine();

				if (thisLine.contains("Potato Crisps")){//Looks at last line of log
					actual = true;
				}
			
			
		}
				
		} catch (Exception e) {
			System.out.println("File not found.");
		}
		Assert.assertEquals(true, actual);
	}
}
