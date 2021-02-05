package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MenuTest {

	@Test
	public void displayOptions_returns_formatted_string_of_given_string_array() {
		Menu initialMenu = new Menu(new String[] { "Display Items", "Purchase", "Exit" });
		Menu purchaseMenu = new Menu(new String[] { "Feed Money", "Select Product", "Finish Transaction" });
		
		String expectedInitialMenu = "1) Display Items\n2) Purchase\n3) Exit\n";
		String expectedPurchaseMenu = "1) Feed Money\n2) Select Product\n3) Finish Transaction\n";
		
		String actualInitialMenu = initialMenu.displayOptions();
		String actualPurchaseMenu = purchaseMenu.displayOptions();
		
		Assert.assertEquals(expectedInitialMenu, actualInitialMenu);
		Assert.assertEquals(expectedPurchaseMenu, actualPurchaseMenu);
	}
	
}
