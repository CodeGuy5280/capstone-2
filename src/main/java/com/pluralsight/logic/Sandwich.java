package com.pluralsight.logic;

import java.util.ArrayList;
import java.util.List;
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


    public Sandwich(String name, String breadType, String size,
                    ArrayList<String> meats,
                    ArrayList<String> extraMeats,
                    ArrayList<String> cheeses,
                    ArrayList<String> extraCheeses,
                    ArrayList<String> regularToppings,
                    ArrayList<String> sauces,
                    ArrayList<String> sides,
                    boolean isToasted) {
        this.name = name;
        this.breadType = breadType;
        this.size = size;
        this.meats = meats;
        this.extraMeats = extraMeats;
        this.cheeses = cheeses;
        this.extraCheeses = extraCheeses;
        this.regularToppings = regularToppings;
        this.sauces = sauces;
        this.sides = sides;
        this.isToasted = isToasted;
    }

    //creation of prebuilt sandwiches using methods, only size and toasted values can be changed
    public static Sandwich createBLT(String size, boolean toasted) {
        return new Sandwich(
                "BLT", "WHITE", size,
                new ArrayList<>(List.of("Bacon")),
                new ArrayList<>(),
                new ArrayList<>(List.of("Cheddar")),
                new ArrayList<>(),
                new ArrayList<>(List.of("Lettuce", "Tomato")),
                new ArrayList<>(List.of("Mayo")),
                new ArrayList<>(),
                toasted
        );
    }

    public static Sandwich createClub(String size, boolean toasted) {
        return new Sandwich(
                "CLUB", "WHEAT", size,
                new ArrayList<>(List.of("Turkey", "Ham", "Bacon")),
                new ArrayList<>(),
                new ArrayList<>(List.of("Swiss")),
                new ArrayList<>(),
                new ArrayList<>(List.of("Lettuce", "Tomato")),
                new ArrayList<>(List.of("Mayo", "Mustard")),
                new ArrayList<>(),
                toasted
        );
    }

    public static Sandwich createRoastBeef(String size, boolean toasted) {
        return new Sandwich(
                "ROAST BEEF", "RYE", size,
                new ArrayList<>(List.of("Roast Beef")),
                new ArrayList<>(),
                new ArrayList<>(List.of("Provolone")),
                new ArrayList<>(),
                new ArrayList<>(List.of("Onions")),
                new ArrayList<>(List.of("Horseradish Sauce")),
                new ArrayList<>(List.of("Au Jus")),
                toasted
        );
    }

    public static Sandwich createTurkeySwiss(String size, boolean toasted) {
        return new Sandwich(
                "TURKEY SWISS", "WHITE", size,
                new ArrayList<>(List.of("Turkey")),
                new ArrayList<>(),
                new ArrayList<>(List.of("Swiss")),
                new ArrayList<>(),
                new ArrayList<>(List.of("Spinach", "Tomato")),
                new ArrayList<>(List.of("Ranch")),
                new ArrayList<>(),
                toasted
        );
    }


    public static Sandwich createPrebuiltSandwich(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Select a Pre-Built Sandwich ---");
            System.out.println("1) BLT");
            System.out.println("2) CLUB");
            System.out.println("3) ROAST BEEF");
            System.out.println("4) TURKEY SWISS");
            System.out.println("5) BUILD YOUR OWN");
            System.out.println("0) Back to Order Menu");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            //option to redirect to build your own menu
            if (choice.equals("5")) {
                System.out.println("Build a custom sandwich...");
                return new Sandwich();
            } else if (choice.equals("0")) {
                System.out.println("Returning to Order Menu.");
                return null;
            }

            // Prompt for size and toasted options
            String size = optionForSize(scanner);
            boolean toasted = optionForToasted(scanner);

            //need to allow for sandwich size choices to be made
            switch (choice) {
                case "1": return createBLT(size, toasted);
                case "2": return createClub(size, toasted);
                case "3": return createRoastBeef(size, toasted);
                case "4": return createTurkeySwiss(size, toasted);
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 5.");
            }
        }
    }

    public Sandwich() {
        // Constructor for custom build
        this.breadType = breadType;
        this.size = size;
        this.name = name;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.isToasted = false;
    }

    // Getter & Setter methods for all fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeats(ArrayList<String> meats) {
        this.meats = meats;
    }

    public ArrayList<String> getExtraMeats() {
        return extraMeats;
    }

    public void setExtraMeats(ArrayList<String> extraMeats) {
        this.extraMeats = extraMeats;
    }

    public void setCheeses(ArrayList<String> cheeses) {
        this.cheeses = cheeses;
    }

    public ArrayList<String> getExtraCheeses() {
        return extraCheeses;
    }

    public void setExtraCheeses(ArrayList<String> extraCheeses) {
        this.extraCheeses = extraCheeses;
    }

    public void setRegularToppings(ArrayList<String> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public ArrayList<String> getSauces() {
        return sauces;
    }

    public void setSauces(ArrayList<String> sauces) {
        this.sauces = sauces;
    }

    public ArrayList<String> getSides() {
        return sides;
    }

    public void setSides(ArrayList<String> sides) {
        this.sides = sides;
    }

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
