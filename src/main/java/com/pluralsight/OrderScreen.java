package com.pluralsight;

import java.util.Scanner;

public class OrderScreen {
    private static final Scanner scanner = new Scanner(System.in);


    public void newOrder(){

        boolean orderInProgress = true;
        while(orderInProgress){
            System.out.println("\n--- New Order ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("Enter your choice: ");


            String choice = scanner.nextLine();

            switch (choice) {
            case "1":
                System.out.println("Select a sandwich: ");
                break;
            case "2":
                System.out.println("Select a drink: ");
                break;
            case "3":
                System.out.println("Select a type of chips: ");
                break;
            case "4":
                System.out.println("Checkout: ");
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
