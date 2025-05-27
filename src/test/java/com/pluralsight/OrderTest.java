package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getTotalPrice() {
        Drink drink1 = new Drink("small", "diet coke");
        Drink drink2 = new Drink("medium", "jack daniels");

        Order order = new Order();
        order.addDrink(drink1);
        order.addDrink(drink2);

        double actualTotalPrice = order.getTotalPrice();

        assertEquals(4.5, actualTotalPrice);

    }
}