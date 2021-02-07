package com.techelevator;

import org.junit.Test;

import org.junit.Assert;

public class ItemClassTest {

	
	@Test
	public void does_get_quantity_return_five() {
		//Arrange
		Item test = new Item("A1", "Potato Crisps", "3.05", "Chips");
		//Assert
		int input = test.getQuantity();
		//Act
		Assert.assertEquals(5, input, 0);
	}
	
	@Test
	public void does_get_item_ID_return() {
		//Arrange
		Item test = new Item("A1", "Potato Crisps", "3.05", "Chips");
		//Assert
		String input = test.getItemID();
		//Act
		Assert.assertEquals("A1", input);
	}
	
	@Test
	public void does_get_name_return() {
		//Arrange
		Item test = new Item("A1", "Potato Crisps", "3.05", "Chips");
		//Assert
		String input = test.getName();
		//Act
		Assert.assertEquals("Potato Crisps", input);
	}
	
	@Test
	public void does_get_price_return() {
		//Arrange
		Item test = new Item("A1", "Potato Crisps", "3.05", "Chips");
		//Assert
		Double input = test.getPrice();
		//Act
		Assert.assertEquals(3.05, input, 0);
	}
	
	@Test
	public void does_get_type_return() {
		//Arrange
		Item test = new Item("A1", "Potato Crisps", "3.05", "Chips");
		//Assert
		String input = test.getType();
		//Act
		Assert.assertEquals("Chips", input);
	}
	
	@Test
	public void does_set_quantity_return_four() {
		//Arrange
		Item test = new Item("A1", "Potato Crisps", "3.05", "Chips");
		//Assert
		test.setQuantity();
		int actual = test.getQuantity();
		//Act
		Assert.assertEquals(4, actual);
	}
}
