package com.pluralsight.logic;

/*select bread (white, wheat, rye, wrap)
 * sandwich size (4", 8", 12")
 * toppings:
 *   (premium extra cost for extra) meat, cheese
 *   (regular) all other toppings, sauces
 * toasted (y/n)
 * can order more than one sandwich
 *  must be prompted to customize each one at a time*/

import java.util.ArrayList;
import java.util.Scanner;

public class Sandwich {
Scanner scanner = new Scanner(System.in);

public static void preBuiltSandwich(){//DONE
    //blt, club, roast beef, turkey swiss
    //each prebuilt will not be editable for simplicity, instead direct user to create their own.
    //need to be stored as set costs based on size only
    boolean running = true;

    while (running){
        System.out.println("1) BLT");
        System.out.println("2) CLUB");
        System.out.println("3) ROAST BEEF");
        System.out.println("4) TURKEY SWISS");
        System.out.println("5) BUILD YOUR OWN");
//        buildYourOwn();
        System.out.println("0) EXIT TO MAIN MENU");
        System.out.println("Enter your choice: "); //done
    }
}

public void buildYourOwn(){
    //connect with all options for selecting, serves as an interface for building a sandwich
    //connect via Arraylists: bread, cheese, toppings, toasted (y/n)
}


    private ArrayList<String> breads = new ArrayList<>();

    public void selectBread() {

        boolean running = true;


        while (running) {

            System.out.println("1) WHITE: ");
            System.out.println("2) WHEAT: ");
            System.out.println("3) RYE: ");
            System.out.println("4) WRAP: ");
            System.out.println("5) LETTUCE: ");
            String choice = scanner.nextLine();

            switch (choice){
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
                case "0":
                    System.out.println("Order canceled! Returning to Homescreen...");
                    running = false;
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }

        }
    }

}
