package com.pluralsight.userinput;

import java.util.Scanner;

public class HomeScreen {
    //Scanner being shared across all instances of HomeScreen instead of creating a Scanner repetitively
    private static final Scanner scanner = new Scanner(System.in);


    //HomeScreen Constructor called when called in Main
    public HomeScreen() {
        //While loop for HomeScreen
        //Boolean set as homeSelect to keep While loop running indefinitely
        boolean homeSelect = true;
        while (homeSelect) {
            System.out.println("##===Welcome to DELIcious!===##");
            System.out.println("Please select an option below: ");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            //User options after program starts
            if (choice.equals("1")) {
                //New OrderScreen object created when 1 is selected
                OrderScreen orderScreen = new OrderScreen();
                //newOrder method called to begin the order process in OrderScreen Class
                orderScreen.newOrder();
            } else if (choice.equals("0")) {
                //If 0 is selected, exit the application
                System.out.println("Exiting the application... Goodbye!");
                homeSelect = false;
                //If input is not recognized as 1 or 0 error is presented to user, they are asked to try again
            } else {
                System.out.println("Invalid input. Please enter only 1 or 0.");
            }
        }
    }
}
