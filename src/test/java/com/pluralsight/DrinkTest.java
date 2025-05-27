package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    void calculatePrice() {
        String sz = "small";
        Drink dc = new Drink(sz, "diet coke");

        double actualPrice = dc.calculatePrice();

        assertEquals(2, actualPrice);

    }
}