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
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            default:
                System.out.println("Please select a valid option.");
        }
        }
    }
}
