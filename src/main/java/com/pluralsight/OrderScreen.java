package com.pluralsight;

import java.util.Scanner;

public class OrderScreen {
    private static final Scanner scanner = new Scanner(System.in);


    public void newOrder(){
         OrderScreen newOrder = new OrderScreen();
        System.out.println("--- New Order ---");

        String choice = scanner.nextLine();
        switch (choice){
             case "1":
                 System.out.println("1) Add Sandwich");
                 break;
             case "2":
                 System.out.println("2) Add Drink");
                 break;
             case "3":
                 System.out.println("3) Add Chips");
                 break;
             case "4":
                 System.out.println("4) Checkout");
                 break;
             case "5":
                 System.out.println("0) Cancel Order");
                 break;
             default:
                 System.out.println("Please select a valid option.");
         }
    }
}
