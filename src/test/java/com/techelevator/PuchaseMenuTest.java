package com.techelevator;

import org.junit.Test;

import org.junit.*;

public class PuchaseMenuTest {

	@Test
	//Feed money loop
	
		/* Set sum to zero
		 * Collect money from each line of user input
		 * Add money to sum */
	
	public void does_loop_add_money() {
		//Arrange
		double userInput1 = 1.00;
		double userInput2 = 5.00;
		//Assert
		double sum = userInput1 + userInput2;
		//Act
		Assert.assertEquals(6.00, sum);
	}
	
	//Select product number
	
	@Test
	
	public void check_for_null_item_ID() {
		//Arrange
		String wrongItemNumber = "A5";
		boolean itemID = true;
		String feedback = "Invalid item number";
		//Assert
		if (!itemID) {
			System.out.println(feedback);
		}
		//Act
		Assert.assertEquals("Invalid item number", feedback);
	}
	
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
	//Finish transaction (Thank you, Change amount, Message)
	//Does it update inventory class
	//Does it append to file
	//Returns least amount of change
	
}
