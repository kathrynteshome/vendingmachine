package com.techelevator;

import java.awt.List;
import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class InventoryClassTest {




	
	@Test
	public void does_it_split_up_last_line_of_csv_into_array() {
		Inventory test = new Inventory();
		String [] expectation = {"D4", "Triplemint", "0.75", "Gum"};
		
		String [] reality = test.parseItemFile();
		
		Assert.assertArrayEquals(expectation, reality);
		
	}
	
	@Test
	public void can_you_access_index_zero_of_array() {
		Inventory test = new Inventory();
		String [] input1 = {"D4", "Triplemint", "0.75", "Gum"};
		String [] output1 = test.parseItemFile();
		String input2 = "D4";
		String output2 = output1[0];
		
		Assert.assertEquals(input2, output2);
		
	}
	
	@Test
	public void match_last_line_of_csv() {
	
		
	}
	
	@Test
	public void adds_items_to_array_list() {
		
		
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
