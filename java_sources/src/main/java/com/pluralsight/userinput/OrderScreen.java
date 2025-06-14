package com.pluralsight.userinput;

import com.pluralsight.logic.*;

import java.util.Scanner;

public class OrderScreen {
    private static final Scanner scanner = new Scanner(System.in);
    private Order currentOrder;

    //constructor to assign currentOrder
    public OrderScreen() {
        this.currentOrder = new Order();
    }


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
                    Sandwich selectedSandwich = Sandwich.createPrebuiltSandwich(scanner);
                    //adding sandwich to order
                    if (selectedSandwich != null) {
                        currentOrder.addSandwich(selectedSandwich);
                        System.out.println("Sandwich added to your order!");
                    }
                    break;
                case "2":
                    System.out.println("Select a drink: ");
                    // Call the static method from the Drink class to handle selection
                    Drink selectedDrink = Drink.selectDrink(scanner);
                    if (selectedDrink != null) { // If a drink was actually selected (not cancelled)
                        currentOrder.addDrink(selectedDrink); // Add the selected drink to the current order
                        System.out.println(selectedDrink.getName() + " (" + selectedDrink.getSize() + ") added to order!");
                    }
                    break;
                case "3":
                    System.out.println("--- Select a Type of Chips ---");
                    // Loop through list from the Chips class to display options
                    for (int i = 0; i < Chips.getAvailableFlavors().size(); i++) {
                        System.out.println((i + 1) + ") " + Chips.getAvailableFlavors().get(i));
                    }
                    System.out.println("0) Cancel Chips Selection");
                    System.out.print("Enter your chips choice: ");
                    String chipsChoice = scanner.nextLine();

                    Chips selectedChips = null;
                    //possibly add a Try Catch Block here
                    int chipsSelection = Integer.parseInt(chipsChoice) - 1;
                    if (chipsSelection >= 0 && chipsSelection < Chips.getAvailableFlavors().size()) {
                        selectedChips = new Chips(Chips.getAvailableFlavors().get(chipsSelection));
                    } else if (chipsChoice.equals("0")) {
                        System.out.println("Chips selection cancelled.");
                    } else {
                        System.out.println("Invalid chips choice.");
                    }

                    if (selectedChips != null) {
                        currentOrder.addChips(selectedChips);
                        System.out.println(selectedChips.getFlavor() + " added to order.");
                    }
                    break;
                case "4":
                    System.out.println("Checkout: ");
                    Checkout checkout = new Checkout(currentOrder);
                    checkout.saveOrderToFile();
                    System.out.println("Order saved.");
                    orderInProgress =false;
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