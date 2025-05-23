package com.pluralsight;

import java.util.Scanner;

public class HomeScreen {
    private static final Scanner scanner = new Scanner(System.in);


    public HomeScreen() {
        boolean homeSelect = true;
        while (homeSelect) {
            System.out.println("##===Welcome to DELIcious!===##");
            System.out.println("Please select an option below: ");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                OrderScreen orderScreen = new OrderScreen();
                orderScreen.newOrder();
            } else if (choice.equals("0")) {
                System.out.println("Exiting the application... Goodbye!");
                homeSelect = false;
            } else {
                System.out.println("Invalid input. Please enter only 1 or 0.");
                scanner.nextLine();
            }
            scanner.close();
        }
    }
}
