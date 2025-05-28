package com.pluralsight.logic;

import java.util.ArrayList;
import java.util.Scanner;

public class Sandwich {
    private String breadType;
    private String size; // e.g., "4-inch", "8-inch", "12-inch"
    private String name;
    private ArrayList<String> meats = new ArrayList<>();
    private ArrayList<String> cheeses = new ArrayList<>();
    private ArrayList<String> regularToppings = new ArrayList<>(); // For veggies, sauces, etc.
    private boolean isToasted;

    public Sandwich(String name, String breadType, String size) {
        // Constructor for pre-built
        this.breadType = breadType;
        this.size = size;
        this.name = name;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.isToasted = false;
    }


    public static Sandwich createPrebuiltSandwich(Scanner scanner) { // Method returns a Sandwich object
        while (true) { // Loop indefinitely until a valid choice is made and returned, or user exits
            System.out.println("\n--- Select a Pre-Built Sandwich ---");
            System.out.println("1) BLT");
            System.out.println("2) CLUB");
            System.out.println("3) ROAST BEEF");
            System.out.println("4) TURKEY SWISS");
            System.out.println("5) BUILD YOUR OWN"); // This option should lead to the buildYourOwn process
            System.out.println("0) Go Back to Order Menu");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            //need to allow for sandwich size choices to be made
            switch (choice) {
                case "1":
                    return new Sandwich("BLT", "White", "8-inch");
                case "2":
                    return new Sandwich("CLUB", "Wheat", "8-inch");
                case "3":
                    return new Sandwich("ROAST BEEF", "Rye", "8-inch");
                case "4":
                    return new Sandwich("TURKEY SWISS", "Wheat", "8-inch");
                case "5":
                    System.out.println("Build a custom sandwich...");
                    return new Sandwich(); // Return an empty Sandwich object for customization
                case "0":
                    System.out.println("Returning to Order Menu.");
                    return null; // Signals to the calling method (OrderScreen) that no sandwich was selected
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 5.");
                    // Loop continues if invalid
            }
        }
    }

    public Sandwich() {
        // Constructor for custom build
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.isToasted = false;
    }

    // Getter methods for all fields
    public String getBreadType() {
        return breadType;
    }

    public String getSize() {
        return size;
    }

    public ArrayList<String> getMeats() {
        return meats;
    }

    public ArrayList<String> getCheeses() {
        return cheeses;
    }

    public ArrayList<String> getRegularToppings() {
        return regularToppings;
    }

    public boolean isToasted() {
        return isToasted;
    }

    // Setter methods (if needed, e.g., for custom build or modifying properties)
    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public void addMeat(String meat) {
        this.meats.add(meat);
    }

    public void addCheese(String cheese) {
        this.cheeses.add(cheese);
    }

    public void addRegularTopping(String topping) {
        this.regularToppings.add(topping);
    }



    public void selectBread(Scanner scanner) { // Takes Scanner as argument
        boolean selected = false;
        while (!selected) {
            System.out.println("--- Choose Your Bread ---");
            System.out.println("1) WHITE");
            System.out.println("2) WHEAT");
            System.out.println("3) RYE");
            System.out.println("4) WRAP");
            System.out.println("0) Back to order menu");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    this.breadType = "WHITE"; // Set the bread type field of THIS sandwich
                    selected = true; // Exit loop
                    break;
                case "2":
                    this.breadType = "WHEAT";
                    selected = true;
                    break;
                case "3":
                    this.breadType = "RYE";
                    selected = true;
                    break;
                case "4":
                    this.breadType = "WRAP";
                    selected = true;
                    break;
                case "0":
                    System.out.println("Returning to order menu...");
                default:
                    System.out.println("Please select a valid bread option (1-4).");
            }
        }
    }
    public void buildYourOwn() {
        //connect with all options for selecting, serves as an interface for building a sandwich
        //connect via Arraylists: bread, cheese, toppings, toasted (y/n)
    }

    public double calculatePrice() {
        return calculatePrice();
    }
}
