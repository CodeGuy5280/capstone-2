package com.pluralsight.logic;

import java.util.Scanner;

public class Drink {
    //Field declaration of name, size, and price of drinks
    private String name;
    private String size; // e.g., "small", "medium", "large"
    private double price;

    //Constructor for drink values
    public Drink(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    //Default constructor placeholder values
    public Drink() {
        this.name = "Pepsi";
        this.size = "small";
        this.price = 0.0;
    }

    //Getter and Setter methods for updating the fields of drinks
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Provides the predefined drink price
    public double calculatePrice() {
        return this.price;
    }

    //Method that returns price for a selected drink size
    private static double getPriceBySize(String size) {
        switch (size.toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                return 0.0;
        }
    }

    public static Drink selectDrink(Scanner scanner) {
        String selectedDrinkName = "";
        String selectedDrinkSize = "";
        double calculatedPrice = 0.0;

        boolean validDrinkTypeSelected = false;
        while (!validDrinkTypeSelected) { // Loop for drink type selection
            System.out.println("\n--- Select Your Drink ---");
            System.out.println("1) Coke");
            System.out.println("2) Pepsi");
            System.out.println("3) Sprite");
            System.out.println("0) Cancel Drink Order");
            System.out.print("Enter your choice: ");
            String drinkChoice = scanner.nextLine();

            switch (drinkChoice) {
                case "1":
                    selectedDrinkName = "Coke";
                    validDrinkTypeSelected = true; // Set to true to exit this loop
                    break;
                case "2":
                    selectedDrinkName = "Pepsi";
                    validDrinkTypeSelected = true; // Set to true to exit this loop
                    break;
                case "3":
                    selectedDrinkName = "Sprite";
                    validDrinkTypeSelected = true; // Set to true to exit this loop
                    break;
                case "0":
                    return null; // User cancelled drink order
                default:
                    System.out.println("Invalid drink choice. Please enter a number from the list.");
                    // validDrinkTypeSelected remains false, so loop reiterates
            }
        } // End of validDrinkTypeSelected loop

        //Displays size options and allows selection
        boolean drinkSizeSelected = false;
        while (!drinkSizeSelected) { // Loop for drink size selection
            System.out.println("\n--- Select " + selectedDrinkName + " Size ---");
            System.out.println("1) Small ($2.00)");
            System.out.println("2) Medium ($2.50)");
            System.out.println("3) Large ($3.00)");
            System.out.println("0) Cancel Size Selection");
            System.out.print("Enter your size choice: ");
            String sizeChoice = scanner.nextLine();

            switch (sizeChoice) {
                case "1":
                    selectedDrinkSize = "Small";
                    calculatedPrice = getPriceBySize("small");
                    drinkSizeSelected = true; // Set to true to exit this loop
                    break;
                case "2":
                    selectedDrinkSize = "Medium";
                    calculatedPrice = getPriceBySize("medium");
                    drinkSizeSelected = true; // Set to true to exit this loop
                    break;
                case "3":
                    selectedDrinkSize = "Large";
                    calculatedPrice = getPriceBySize("large");
                    drinkSizeSelected = true; // Set to true to exit this loop
                    break;
                case "0":
                    System.out.println("Size selection cancelled.");
                    return null; // User cancelled size selection
                default:
                    System.out.println("Invalid size choice. Please enter 1, 2, 3, or 0.");
                    // drinkSizeSelected remains false, so loop reiterates
            }
        } // End of drinkSizeSelected loop

        // Return the fully selected Drink object
        return new Drink(selectedDrinkName, selectedDrinkSize, calculatedPrice);
    }
}