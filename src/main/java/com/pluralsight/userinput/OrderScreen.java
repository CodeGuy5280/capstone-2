package com.pluralsight.userinput;

import com.pluralsight.logic.Chips;
import com.pluralsight.logic.Drink;
import com.pluralsight.logic.Sandwich;

import java.util.Scanner;

public class OrderScreen {
    private static final Scanner scanner = new Scanner(System.in);


    public void newOrder() {

        boolean orderInProgress = true;
        while (orderInProgress) {
            System.out.println("\n--- New Order ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order"); //done
            System.out.println("Enter your choice: "); //done


            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Select a sandwich or build your own: ");
                    Sandwich.createPrebuiltSandwich(scanner);
                    break;
                case "2":
                    System.out.println("Select a drink: ");
                    Drink selectedDrink = new Drink("small", "Dr. Pepper");
                    break;
                case "3":
                    System.out.println("--- Select a Type of Chips ---");
                    // Loop through the static list from the Chips class to display options
                    for (int i = 0; i < Chips.getAvailableFlavors().size(); i++) {
                        System.out.println((i + 1) + ") " + Chips.getAvailableFlavors().get(i));
                    }
                    System.out.println("0) Cancel Chips Selection");
                    System.out.print("Enter your chips choice: ");
                    String chipsChoice = scanner.nextLine();

                    Chips selectedChips = null;
                    int chipsSelection = Integer.parseInt(chipsChoice) - 1;
                    if (chipsSelection >= 0 && chipsSelection < Chips.getAvailableFlavors().size()) {
                        selectedChips = new Chips(Chips.getAvailableFlavors().get(chipsSelection));
                    } else if (chipsChoice.equals("0")) {
                        System.out.println("Chips selection cancelled.");
                    } else {
                        System.out.println("Invalid chips choice.");
                    }

                    if (selectedChips != null) {
                        // Add selectedChips to your Order object
                        System.out.println(selectedChips.getFlavor() + " added to order.");
                    }
                    break;
                case "4":
                    System.out.println("Checkout: ");
                    //class.method();
                    break;
                case "0":
                    System.out.println("Order canceled! Returning to Homescreen...");
                    orderInProgress = false;
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }
}