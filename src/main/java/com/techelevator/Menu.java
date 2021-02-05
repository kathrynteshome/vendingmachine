package com.techelevator;

import java.util.Scanner;

public abstract class Menu {
	
	public String getUserInput() {
		Scanner userInput = new Scanner(System.in);
		String input = userInput.nextLine();
		
		return input;
	}
	
	public void displayOptions(String[] options) {
		int optionNum = 1;
		
		for (String option : options) {
			System.out.println(optionNum + ") " + option);
			optionNum++;
		}
	}
	
	public abstract void processUserInput(String input);

}
