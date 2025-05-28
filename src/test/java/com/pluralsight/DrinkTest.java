package com.pluralsight;

import com.pluralsight.logic.Drink;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    void calculatePrice() {
        Drink dc = new Drink("Cola", "small", 2.0);

        double actualPrice = dc.calculatePrice();

        assertEquals(2, actualPrice);

    }
}