package com.techelevator;

import java.util.Scanner;

public class Menu {
	
	private String[] options;
	
	public Menu(String[] options) {
		this.options = options;
	}
	
	public String getUserInput() {
		Scanner userInput = new Scanner(System.in);
		String input = userInput.nextLine();
		
		return input;
	}
	
	public String displayOptions() {
		int optionNum = 1;
		String optionsChoice = "\n************\n";
		
		for (String option : options) {
			optionsChoice += optionNum + ") " + option + "\n" + "************\n";
			optionNum++;
		}
		
		return optionsChoice;
	}
}
