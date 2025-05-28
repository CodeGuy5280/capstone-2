package com.pluralsight.logic;

import java.util.Scanner;

public class Drink {
    private String name;
    private String size; // e.g., "small", "medium", "large"
    private double price;

    public Drink(String name, String size) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    // Default constructor if needed
    public Drink() {
        this.name = "Unknown";
        this.size = "medium";
        this.price = 0.0;
    }

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

    public double calculatePrice() {
        // For simplicity, let's just return the set price.
        // You could add logic here for different prices based on size, etc.
        return this.price;
    }

    // Example static method to select a drink, similar to Sandwich.createPrebuiltSandwich
    public static Drink selectDrink(Scanner scanner) {
        System.out.println("\n--- Select Your Drink ---");
        System.out.println("1) Coke (2.00)");
        System.out.println("2) Pepsi (2.00)");
        System.out.println("3) Sprite (2.00)");
        System.out.println("0) Cancel");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1": return new Drink("Coke", "Medium");
            case "2": return new Drink("Dr. Pepper", "Medium");
            case "3": return new Drink("Sprite", "Medium");
            case "0": return null; // User cancelled
            default: System.out.println("Invalid drink choice.");
            return null;
        }
    }
}