package com.pluralsight;

import java.util.Scanner;

public class HomeScreen {
    Scanner scanner = new Scanner(System.in);

    boolean input = true;

    public HomeScreen(){
        boolean homeSelect = true;
        while (homeSelect){
            System.out.println("##===Welcome to DELIcious!===##");
            System.out.println("Please select an option below: ");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            String choice = scanner.nextLine();

            if(choice.equals("1")){
                System.out.println("New Order -->");
            } else if (choice.equals("0")) {
                System.out.println("Exiting the application... Goodbye!");
                homeSelect = false;
            }else {
                System.out.println("Invalid input. Please enter only 1 or 0.");
            }
        }
    }
}
