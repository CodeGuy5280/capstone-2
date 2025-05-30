package com.pluralsight.userinput;

import com.pluralsight.logic.*;

import java.util.Scanner;

public class OrderScreen {
    //Scanner defined to pass in this class as a parameter
    private static final Scanner scanner = new Scanner(System.in);
    //Private instance of type Order called currentOrder that holds the order being built
    private Order currentOrder;//make final?

    //Constructor to assign currentOrder, creates new order object
    public OrderScreen() {
        this.currentOrder = new Order();
    }

    //Displays the menu loop for orders
    public void newOrder() {
        //Boolean to ensure start of while loop of options
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
                    //Calls a static method from the Sandwich Class createPrebuiltSandwich
                    Sandwich selectedSandwich = Sandwich.createPrebuiltSandwich(scanner);
                    //adding sandwich to order
                    if (selectedSandwich != null) {
                        //If a selectedSandwich is valid it is added to the currentOrder
                        currentOrder.addSandwich(selectedSandwich);
                        System.out.println("Sandwich added to your order!");
                    }
                    break;
                case "2":
                    System.out.println("Select a drink: ");
                    // Call the static method from the Drink class selectDrink
                    Drink selectedDrink = Drink.selectDrink(scanner);
                    // If a drink was actually selected (not cancelled)
                    if (selectedDrink != null) {
                        // Add the selected drink to the current order
                        currentOrder.addDrink(selectedDrink);
                        System.out.println(selectedDrink.getName() + " (" + selectedDrink.getSize() + ") added to order!");
                    }
                    break;
                case "3":
                    System.out.println("--- Select a Type of Chips ---");
                    // Loop through list from the Chips class to display flavor options
                    for (int i = 0; i < Chips.getAvailableFlavors().size(); i++) {
                        System.out.println((i + 1) + ") " + Chips.getAvailableFlavors().get(i));
                    }
                    System.out.println("0) Cancel Chips Selection");
                    System.out.print("Enter your chips choice: ");
                    String chipsChoice = scanner.nextLine();

                    Chips selectedChips = null;
                    //Takes user input, converts to index for selection
                    int chipsSelection = Integer.parseInt(chipsChoice) - 1;
                    //Selection is validated through comparison operators
                    if (chipsSelection >= 0 && chipsSelection < Chips.getAvailableFlavors().size()) {
                        selectedChips = new Chips(Chips.getAvailableFlavors().get(chipsSelection));
                    } else if (chipsChoice.equals("0")) {
                        System.out.println("Chips selection cancelled.");
                    } else {
                        System.out.println("Invalid chips choice.");
                    }
                    //Adds chips to the order
                    if (selectedChips != null) {
                        currentOrder.addChips(selectedChips);
                        System.out.println(selectedChips.getFlavor() + " added to order.");
                    }
                    break;
                case "4":
                    System.out.println("Checkout: ");
                    //Creates a Checkout object, saves the order and exits loop
                    Checkout checkout = new Checkout(currentOrder);
                    checkout.saveOrderToFile();
                    System.out.println("Order saved.");
                    orderInProgress = false;
                    break;
                case "0":
                    System.out.println("Order canceled! Returning to Homescreen...");
                    //Cancels order, returns to HomeScreen
                    orderInProgress = false;
                    break;
                    //Default for invalid input
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }

}