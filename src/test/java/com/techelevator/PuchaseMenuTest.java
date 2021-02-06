package com.techelevator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class PuchaseMenuTest {
	
	@Test
	public void minimal_change_test() {
		
		//Arrange
		String [] testStringArray = {"Feed Money", "Select Product", "Finish Transaction"};
		List<Item> inventory = new ArrayList <>();
		Item testItemClass1 = new Item("A1", "Potato Crisps", "3.05", "Chips");
		Item testItemClass2 = new Item ("D2", "Little League Chew", "0.95", "Gum");
		inventory.add(testItemClass1);
		inventory.add(testItemClass2);
		PurchaseMenu test = new PurchaseMenu(testStringArray, inventory);
		
		//Assert
		Double startingBalance = 6.89;
		String expectation = "Your change is: 27 quarter(s)\n1 dime(s)\4 pennies";
		String reality = test.finalizeTransaction();
		
		//Act
		Assert.assertEquals (expectation, reality);
	}
	//check current balance for each of the methods
	
	@Test
	public void does_handle_input_return_method_for_one() {
		//Arrange
		String [] testStringArray = {"Feed Money", "Select Product", "Finish Transaction"};
		List<Item> inventory = new ArrayList <>();
		Item testItemClass1 = new Item("A1", "Potato Crisps", "3.05", "Chips");
		Item testItemClass2 = new Item ("D2", "Little League Chew", "0.95", "Gum");
		inventory.add(testItemClass1);
		inventory.add(testItemClass2);
		PurchaseMenu test = new PurchaseMenu(testStringArray, inventory);
		//Assert
		
		boolean expected = test.handleInput();
		boolean actual = 
		//Act
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void does_loop_add_money() {
		//Arrange
		String [] testStringArray = {"Feed Money", "Select Product", "Finish Transaction"};
		List<Item> inventory = new ArrayList <>();
		PurchaseMenu test = new PurchaseMenu(testStringArray, inventory);
		double userInput1 = 1.00;
		double userInput2 = 5.00;
		//Assert
		double sum = userInput1 + userInput2;
		//Act
		Assert.assertEquals (6.00, sum, 0);
	}
	
	@Test
	
	public void check_for_null_item_ID() {
		//Arrange
		//Arrange
		}
		//Act
		Assert.assertEquals("Invalid item number", feedback);
	}
	
	@Test
	public void check_if_product_quantity_is_zero() {
		//Arrange
		int quantity = 0;
		String feedback = "Item not available";
		//Assert
		if (quantity == 0) {
			System.out.println(feedback);
		}
		//Act
		Assert.assertEquals("Item not available", feedback);
	}
	@Test
	public void check_if_cash_feed_less_than_price() {
		//Arrange
		double cashFeedSum = 2;
		double itemPrice = 3;
		String feedback = "Insufficient funds";
		//Assert
		if (cashFeedSum < itemPrice) {
			System.out.println(feedback);
		}
		//Act
		Assert.assertEquals("Insufficient funds", feedback);
	}
	
	@Test
	public void check_correct_change_amount() {
		//Arrange
		double cashFeedSum = 2;
		double itemPrice = 1.25;
		//Assert
		double change = cashFeedSum - itemPrice;
		
		//Act
		Assert.assertEquals(0.75, change);
	}
	
	@Test
	public void returns_least_amount_of_change() {
		//Arrange
		double changeAmount = 0.74;
		int amountOfCoins = 8; 
		//Assert
		//??
		//Act
		Assert.assertEquals(8, amountOfCoins);
	}
	
	@Test
	public void tells_user_message() {
		//Arrange
		boolean completedPayment = true;
		String type = "candy";
		String message = "Munch Munch, Yum! Thank You!";
		//Assert
		if (completedPayment) {
			if (type.equals("candy")) {
				System.out.println(message);
			}
		}
		//Act
		Assert.assertEquals("Munch Munch, Yum!", message);
	}
	
	@Test
	public void does_it_update_inventory_class_when_item_is_purchased() {
		//Arrange
		Inventory test = new Inventory();
		int quantity = 5;
		//Assert
		
		
		//Act
	}
	
	@Test
	public void does_it_append_file() {
		//Arrange
		//Assert
		//Act
	}
	
	
	
	
}
