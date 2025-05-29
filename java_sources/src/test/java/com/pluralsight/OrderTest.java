package com.pluralsight;

import com.pluralsight.logic.Drink;
import com.pluralsight.logic.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getTotalPriceForDrinks() { // Renamed method for clarity
        // Create drinks with very simple, clear prices
        Drink drink1 = new Drink("Water", "small", 1.0); // Price: $1.00
        Drink drink2 = new Drink("Juice", "medium",2.0); // Price: $2.00

        Order order = new Order();
        order.addDrink(drink1);
        order.addDrink(drink2);

        double actualTotalPrice = order.getTotalPrice();

        // Expected total is 1.00 + 2.00 = 3.00
        assertEquals(3.00, actualTotalPrice);
    }
}