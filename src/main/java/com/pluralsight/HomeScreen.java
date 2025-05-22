package com.pluralsight;

import java.util.Scanner;

public class HomeScreen {
    Scanner scanner = new Scanner(System.in);



    public HomeScreen(){
        boolean homeSelect = true;
        while (homeSelect){
            System.out.println("##==Welcome to DELIcious!==##");
            System.out.println("Please select an option below: ");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            scanner.nextLine();


        break;
        }
    }
}
