package com.pluralsight.logic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Checkout {
    //Customer's complete order
    private Order order;

    //Constructor when a Checkout object is created (Order object parameter), access to the complete order
    public Checkout(Order order) {
        this.order = order;
    }

    //Writes order to a txt file
    public void saveOrderToFile() {
        //location of file
        String fileName = ("src/main/resources/orders.txt");

        //Creates FileWriter, appends to file above ^
        //Try block used for resource management (auto closes)
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("=== New Order ===\n");

            // Write sandwich details, looping through sandwiches in the order
            for (Sandwich sandwich : order.getSandwiches()) {
                //Individual attributes being written
                writer.write("Sandwich: " + sandwich.getName() + " " + "\n");
                writer.write("- Size: " + sandwich.getSize() + "\n");
                writer.write("- Toasted: " + (sandwich.isToasted() ? "Yes" : "No") + "\n");
                writer.write("- Bread: " + sandwich.getBreadType() + "\n");

                //Iterates through meats List, separation with commas on line 38
                writer.write("- Meats: ");
                List<String> meats = sandwich.getMeats();
                for (int i = 0; i < meats.size(); i++) {
                    writer.write(meats.get(i));
                    if (i < meats.size() - 1) writer.write(", ");
                }
                writer.write("\n");

                //Gets cheese name for the sandwich
                writer.write("- Cheese: " + sandwich.getCheese() + "\n");

                //Same as Meats
                writer.write("- Toppings: ");
                List<String> toppings = sandwich.getRegularToppings();
                for (int i = 0; i < toppings.size(); i++) {
                    writer.write(toppings.get(i));
                    if (i < toppings.size() - 1) writer.write(", ");
                }
                writer.write("\n");

                //Same as Meats & Toppings
                writer.write("- Sauces: ");
                List<String> sauces = sandwich.getSauces();
                for (int i = 0; i < sauces.size(); i++) {
                    writer.write(sauces.get(i));
                    if (i < sauces.size() - 1) writer.write(", ");
                }
                writer.write("\n");

                //Writing Sandwich price
                writer.write("- Price: $" + sandwich.calculatePrice() + "\n");
            }

            // Write drink details, for each looping through Drink objects in order
            for (Drink drink : order.getDrinks()) {
                writer.write("Drink: " + drink.getName() + " (" + drink.getSize() + ")" + " $" + drink.calculatePrice() + "\n");
            }

            // Write chips details
            for (Chips chips : order.getChips()) {
                writer.write("Chips: " + chips.getFlavor() + " $" + chips.calculatePrice() + "\n");
            }

            // Write total price
            writer.write("Total Price: $" + order.getTotalPrice() + "\n");
            writer.write("\n");

            System.out.println("Order saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving order: " + e.getMessage());
        }
    }
}
