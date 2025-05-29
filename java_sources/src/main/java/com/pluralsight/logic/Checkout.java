package com.pluralsight.logic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Checkout {
    private Order order;

    public Checkout(Order order) {
        this.order = order;
    }

    public void saveOrderToFile() {
        String fileName = ("src/main/resources/orders.txt");

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("=== New Order ===\n");

            // Write sandwich details
            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write("Sandwich:\n");
                writer.write("- Size: " + sandwich.getSize() + "\n");
                writer.write("- Toasted: " + (sandwich.isToasted() ? "Yes" : "No") + "\n");
                writer.write("- Bread: " + sandwich.getBreadType() + "\n");

                writer.write("- Meats: ");
                List<String> meats = sandwich.getMeats();
                for (int i = 0; i < meats.size(); i++) {
                    writer.write(meats.get(i));
                    if (i < meats.size() - 1) writer.write(", ");
                }
                writer.write("\n");

                writer.write("- Cheese: " + sandwich.getCheese() + "\n");

                writer.write("- Toppings: ");
                List<String> toppings = sandwich.getRegularToppings();
                for (int i = 0; i < toppings.size(); i++) {
                    writer.write(toppings.get(i));
                    if (i < toppings.size() - 1) writer.write(", ");
                }
                writer.write("\n");

                writer.write("- Sauces: ");
                List<String> sauces = sandwich.getSauces();
                for (int i = 0; i < sauces.size(); i++) {
                    writer.write(sauces.get(i));
                    if (i < sauces.size() - 1) writer.write(", ");
                }
                writer.write("\n");

                writer.write("- Price: $" + sandwich.calculatePrice() + "\n");
            }

            // Write drink details
            for (Drink drink : order.getDrinks()) {
                writer.write("Drink: " + drink.getName() + " (" + drink.getSize() + ")\n");
            }

            // Write chips details
            for (Chips chips : order.getChips()) {
                writer.write("Chips: " + chips.getFlavor() + "\n");
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
