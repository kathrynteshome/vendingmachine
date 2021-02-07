package com.techelevator;

public class Application {

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		Menu menu = new Menu(new String[] { "Display Items", "Purchase", "Exit" });
		PurchaseMenu purchase = new PurchaseMenu(new String[] { "Feed Money", "Select Product", "Finish Transaction" }, inventory.getInventory());

		boolean isRunning = true;

		while (isRunning) {
			System.out.println(menu.displayOptions());
			String userIn = menu.getUserInput();
			
			if (userIn.equals("1")) {

				inventory.displayInventory();
				
				
			} else if (userIn.equals("2")) {
				boolean finished = false;

				while (!finished) {

					inventory.displayInventory();

					System.out.println(purchase.displayOptions());
					userIn = purchase.getUserInput();

					finished = purchase.handleInput(userIn);
				}

			} else if (userIn.equals("3")) {

				System.out.println("Thank you for using our Vend-a-tron > 9000\nPlease come again");
				isRunning = false;

			}
		}
	}

}
