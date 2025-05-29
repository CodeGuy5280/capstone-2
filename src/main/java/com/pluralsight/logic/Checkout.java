package com.pluralsight.logic;

import java.io.FileWriter;
import java.io.IOException;

public class Checkout {

    public void saveOrderToFile() {
        String fileName = "orders.txt";
        //TODO: fix errors
        try (FileWriter writer = new FileWriter(fileName, true)) { // true = append mode
            writer.write("=== New Order ===\n");
            writer.write("Size: " + this.size + "\n");
            writer.write("Toasted: " + (this.isToasted ? "Yes" : "No") + "\n");
            writer.write("Bread: " + this.bread + "\n");
            writer.write("Meats: " + String.join(", ", this.meats) + "\n");
            writer.write("Cheese: " + this.cheese + "\n");
            writer.write("Toppings: " + String.join(", ", this.toppings) + "\n");
            writer.write("Sauces: " + String.join(", ", this.sauces) + "\n");
            writer.write("Price: $" + this.calculatePrice() + "\n");
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("Error saving order: " + e.getMessage());
        }
    }


}
