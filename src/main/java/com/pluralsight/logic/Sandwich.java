package com.pluralsight.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sandwich {
    private String name; // Added for pre-built names like BLT, CLUB
    private String breadType;
    private String size; // e.g., "4-inch", "8-inch", "12-inch"
    private ArrayList<String> meats = new ArrayList<>();
    private ArrayList<String> extraMeats = new ArrayList<>(); // To track extra meats
    private ArrayList<String> cheeses = new ArrayList<>();
    private ArrayList<String> extraCheeses = new ArrayList<>(); // To track extra cheeses
    private ArrayList<String> regularToppings = new ArrayList<>(); // For veggies, sauces, etc.
    private ArrayList<String> sauces = new ArrayList<>(); // Specific list for sauces
    private ArrayList<String> sides = new ArrayList<>();   // Specific list for sides (like au jus)
    private boolean isToasted;

    //there has to be a better way to do this
    public Sandwich(String name, String breadType, String size,
                    ArrayList<String> meats, ArrayList<String> extraMeats,
                    ArrayList<String> cheeses, ArrayList<String> extraCheeses,
                    ArrayList<String> regularToppings, ArrayList<String> sauces, ArrayList<String> sides,
                    boolean isToasted) {
        this.name = name;
        this.breadType = breadType;
        this.size = size;
        this.meats = new ArrayList<>(meats); // Defensive copy
        this.extraMeats = new ArrayList<>(extraMeats);
        this.cheeses = new ArrayList<>(cheeses);
        this.extraCheeses = new ArrayList<>(extraCheeses);
        this.regularToppings = new ArrayList<>(regularToppings);
        this.sauces = new ArrayList<>(sauces);
        this.sides = new ArrayList<>(sides);
        this.isToasted = isToasted;
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

    //Getter methods for all fields
    public String getName() { return name; } // Added getter for name
    public String getBreadType() { return breadType; }
    public String getSize() { return size; }
    public ArrayList<String> getMeats() { return meats; }
    public ArrayList<String> getExtraMeats() { return extraMeats; }
    public ArrayList<String> getCheeses() { return cheeses; }
    public ArrayList<String> getExtraCheeses() { return extraCheeses; }
    public ArrayList<String> getRegularToppings() { return regularToppings; }
    public ArrayList<String> getSauces() { return sauces; }
    public ArrayList<String> getSides() { return sides; }
    public boolean isToasted() { return isToasted; }

    //Setter methods (for custom build and build your own)
    public void setName(String name) { this.name = name; }
    public void setBreadType(String breadType) { this.breadType = breadType; }
    public void setSize(String size) { this.size = size; }
    public void setToasted(boolean toasted) { isToasted = toasted; }
    public void addMeat(String meat) { this.meats.add(meat); }
    public void addExtraMeat(String meat) { this.extraMeats.add(meat); }
    public void addCheese(String cheese) { this.cheeses.add(cheese); }
    public void addExtraCheese(String cheese) { this.extraCheeses.add(cheese); }
    public void addRegularTopping(String topping) { this.regularToppings.add(topping); }
    public void addSauce(String sauce) { this.sauces.add(sauce); }
    public void addSide(String side) { this.sides.add(side); }

    //adding helper method for pricing based on size
    private static double getBasePriceBySize(String size) {
        switch (size.toLowerCase()) {
            case "4-inch": return 5.50;
            case "8-inch": return 7.00;
            case "12-inch": return 8.50;
            default: return 0.0; //in case somehow nothing is selected
        }
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
