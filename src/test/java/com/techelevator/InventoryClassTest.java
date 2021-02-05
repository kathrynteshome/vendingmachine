package com.techelevator;

import org.junit.Test;

public class InventoryClassTest {

	
	@Test
	public void check_if_file_null() {
		Inventory test = new Inventory(new Item("A1", "Potato Crisps", "3.05", "Chips"));
		
		
	}
	
	@Test
	public void check_if_file_is_found() {
		Inventory test = new Inventory(new Item("A1", "Potato Crisps", "3.05", "Chips"));
		
		
	}
	
	@Test
	public void match_first_line_of_csv() {
		Inventory test = new Inventory();
		
		
	}
	
	@Test
	public void does_it_split_up_csv() {
		Inventory test = new Inventory();
		
		
	}
	
	

}

//Does it read from file
//Does it access quantity
//Does it access price
//Does it access type

//Giving a layout for 


//A1|Potato Crisps|3.05|Chip
//A2|Stackers|1.45|Chip
//A3|Grain Waves|2.75|Chip
//A4|Cloud Popcorn|3.65|Chip
//B1|Moonpie|1.80|Candy
//B2|Cowtales|1.50|Candy
//B3|Wonka Bar|1.50|Candy
//B4|Crunchie|1.75|Candy
//C1|Cola|1.25|Drink
//C2|Dr. Salt|1.50|Drink
//C3|Mountain Melter|1.50|Drink
//C4|Heavy|1.50|Drink
//D1|U-Chews|0.85|Gum
//D2|Little League Chew|0.95|Gum
//D3|Chiclets|0.75|Gum
//D4|Triplemint|0.75|Gum
