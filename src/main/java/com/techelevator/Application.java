package com.techelevator;

public class Application {

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		Menu menu = new Menu(new String[] { "Display Items", "Purchase", "Exit" });
		PurchaseMenu purchase = new PurchaseMenu(new String[] { "Feed Money", "Select Product", "Finish Transaction" }, inventory.getInventory());
		SalesReport sr = new SalesReport(inventory.getInventory());
		double totalSales = 0;
		
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
					
					double[] output = purchase.handleInput(userIn);
					totalSales = output[1];
					
					if (output[0] == 0) {
						finished = false;
					} else if (output[0] == 1) {
						finished = true;
					}
				}

			} else if (userIn.equals("3")) {

				System.out.println("Thank you for using our Vend-a-tron > 9000\nPlease come again");
				isRunning = false;

			} else if (userIn.equals("4")) {
				sr.makeSalesReport(totalSales);
			}
		}
	}

}
