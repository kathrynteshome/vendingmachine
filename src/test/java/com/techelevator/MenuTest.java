package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MenuTest {

	@Test
	public void displayOptions_returns_formatted_string_of_given_string_array() {
		Menu initialMenu = new Menu(new String[] { "Display Items", "Purchase", "Exit" });
		Menu purchaseMenu = new Menu(new String[] { "Feed Money", "Select Product", "Finish Transaction" });
		
		String expectedInitialMenu = "\n************\n1) Display Items\n************\n2) Purchase\n************\n3) Exit\n************\n";
	
		
		String actualInitialMenu = initialMenu.displayOptions();
		
		
		Assert.assertEquals(expectedInitialMenu, actualInitialMenu);
		
	}
	
}
