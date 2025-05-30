package com.pluralsight.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich {
    //Stores values in variables
    private String name; // Added for pre-built names like BLT, CLUB
    private String breadType;
    private String size; // e.g., "4-inch", "8-inch", "12-inch"
    //Stores all choices for each selection by user
    private ArrayList<String> meats = new ArrayList<>();
    private ArrayList<String> extraMeats = new ArrayList<>(); // To track extra meats
    private ArrayList<String> cheeses = new ArrayList<>();
    private ArrayList<String> extraCheeses = new ArrayList<>(); // To track extra cheeses
    private ArrayList<String> regularToppings = new ArrayList<>(); // For veggies, sauces, etc.
    private ArrayList<String> sauces = new ArrayList<>(); // Specific list for sauces
    private ArrayList<String> sides = new ArrayList<>();   // Specific list for sides
    //If Toasted or not
    private boolean isToasted;

    //Constructor accepting many parameters for the Sandwich
    public Sandwich(String name, String breadType, String size,
                    ArrayList<String> meats,
                    ArrayList<String> extraMeats,
                    ArrayList<String> cheeses,
                    ArrayList<String> extraCheeses,
                    ArrayList<String> regularToppings,
                    ArrayList<String> sauces,
                    ArrayList<String> sides,
                    boolean isToasted) {
        //This is used to assign parameters to the instances above ^
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

    //creation of predefined prebuilt sandwiches using methods, only size and toasted values can be changed
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
                "CLUB", "WHITE", size,
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
                "TURKEY SWISS", "SOURDOUGH", size,
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

    //Menu start for selection of prebuilt sandwich, option to BUILD YOUR OWN or go back to Order Menu
    //
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
                Sandwich custom = new Sandwich();
                custom.buildYourOwn(scanner);
                return custom;
            } else if (choice.equals("0")) {
                System.out.println("Returning to Order Menu.");
                return null;
            }
            // Prompt for size and toasted options
            String size = optionForSize(scanner);
            boolean toasted = optionForToasted(scanner);

            switch (choice) {
                case "1":
                    return createBLT(size, toasted);
                case "2":
                    return createClub(size, toasted);
                case "3":
                    return createRoastBeef(size, toasted);
                case "4":
                    return createTurkeySwiss(size, toasted);
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 5.");
            }
        }
    }

    //Helper methods to select Size from options
    private static String optionForSize(Scanner scanner) {
        while (true) {
            System.out.println("Choose a size: 1) 4-inch  2) 8-inch  3) 12-inch");
            String sizeChoice = scanner.nextLine();
            switch (sizeChoice) {
                case "1":
                    return "4-inch";
                case "2":
                    return "8-inch";
                case "3":
                    return "12-inch";
                default:
                    System.out.println("Invalid size. Please choose 1, 2, or 3.");
            }
        }
    }

    //Helper methods to select Toasted from options
    private static boolean optionForToasted(Scanner scanner) {
        while (true) {
            System.out.print("Would you like it toasted? (yes/no): ");
            String toastedChoice = scanner.nextLine().trim().toLowerCase();
            if (toastedChoice.equals("yes")) return true;
            if (toastedChoice.equals("no")) return false;
            System.out.println("Please type 'yes' or 'no'.");
        }
    }

    //Default constructor used for building a CUSTOM SANDWICH
    public Sandwich() {
        // Constructor for custom build
//        this.breadType = breadType;
//        this.size = size;
//        this.name = name;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.isToasted = false;
    }

    // Getter & Setter methods for all fields
    //Allows other classes to change private variables
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

    public ArrayList<String> getCheese() {
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

    //Add ingredients methods
    public void addMeat(String meat) {
        this.meats.add(meat);
    }

    public void addCheese(String cheese) {
        this.cheeses.add(cheese);
    }

    public void addRegularTopping(String topping) {
        this.regularToppings.add(topping);
    }


    //User choice of bread type
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
                    selected = false;
                default:
                    System.out.println("Please select a valid bread option (1-4).");
            }
        }
    }

    //All options to BUILD YOUR OWN SANDWICH, loops for each choice to add more
    public void buildYourOwn(Scanner scanner) {
        System.out.println("--- Build Your Own Sandwich ---");

        // 1. Choose size
        this.size = optionForSize(scanner);

        // 2. Toasted?
        this.isToasted = optionForToasted(scanner);

        // 3. Choose bread
        selectBread(scanner);

        // 4. Select meats
        boolean selectingMeats = true;

        while (selectingMeats) {
            System.out.println("\n--- Add Meats ---");
            System.out.println("1) Turkey");
            System.out.println("2) Ham");
            System.out.println("3) Roast Beef");
            System.out.println("4) Bacon");
            System.out.println("5) Salami");
            System.out.println("0) Done with meats");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    this.meats.add("Turkey");
                    break;
                case "2":
                    this.meats.add("Ham");
                    break;
                case "3":
                    this.meats.add("Roast Beef");
                    break;
                case "4":
                    this.meats.add("Bacon");
                    break;
                case "5":
                    this.meats.add("Salami");
                    break;
                case "0":
                    System.out.println("Finished adding meats.");
                    selectingMeats = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        Cheese:
        // 5. Select cheeses
        while (true) {
            System.out.println("\n--- Add Cheeses ---");
            System.out.println("1) Cheddar\n2) Swiss\n3) Provolone\n4) Pepper Jack");
            System.out.println("0) Done with cheeses");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addCheese("Cheddar");
                    break;
                case "2":
                    addCheese("Swiss");
                    break;
                case "3":
                    addCheese("Provolone");
                    break;
                case "4":
                    addCheese("Pepper Jack");
                    break;
                case "0":
                    break Cheese;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        Toppings:
        // 6. Select regular toppings
        while (true) {
            System.out.println("\n--- Add Toppings ---");
            System.out.println("1) Lettuce\n2) Tomato\n3) Onion\n4) Spinach\n5) Pickles");
            System.out.println("0) Done with toppings");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addRegularTopping("Lettuce");
                    break;
                case "2":
                    addRegularTopping("Tomato");
                    break;
                case "3":
                    addRegularTopping("Onion");
                    break;
                case "4":
                    addRegularTopping("Spinach");
                    break;
                case "5":
                    addRegularTopping("Pickles");
                    break;
                case "0":
                    break Toppings;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        Sauces:
        // 7. Select sauce(s)
        while (true) {
            System.out.println("\n--- Add Sauces ---");
            System.out.println("1) Mayo\n2) Mustard\n3) Ranch\n4) Horseradish Sauce");
            System.out.println("0) Done with sauces");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    sauces.add("Mayo");
                    break;
                case "2":
                    sauces.add("Mustard");
                    break;
                case "3":
                    sauces.add("Ranch");
                    break;
                case "4":
                    sauces.add("Horseradish Sauce");
                    break;
                case "0":
                    break Sauces;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        Sides:
        // 8. Select sides
        while (true) {
            System.out.println("\n--- Add Sides ---");
            System.out.println("1) Chips");
            System.out.println("1) Chips");
            System.out.println("2) Cookie");
            System.out.println("3) Au Jus");
            System.out.println("0) Done with sides");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            //TODO:add cookie cost to sides
            switch (choice) {
                case "1":
                    sides.add("Chips");
                    break;
                case "2":
                    sides.add("Cookie");
                    break;
                case "0":
                    break Sides;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        // 9. Set name
        this.name = "Custom Sandwich";
        System.out.println("\n✅ Your custom sandwich has been created!");
    }

    //Sandwich price calculator using basePrice, adding additional cost with each extra option
    public double calculatePrice() {
        double basePrice;

        switch (size) {
            case "4-inch":
                basePrice = 5.00;
                break;
            case "8-inch":
                basePrice = 7.00;
                break;
            case "12-inch":
                basePrice = 9.00;
                break;
            default:
                basePrice = 6.00;
                break;
        }

        basePrice += extraMeats.size() * 1.00;
        basePrice += extraCheeses.size() * 0.75;
        basePrice += sides.size() * 1.50;
        return basePrice;
    }

}
