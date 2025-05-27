package com.pluralsight;

import java.util.ArrayList;

public class Order {


    private ArrayList<Drink> drinks = new ArrayList<>();

    public void addDrink(Drink d) {
        this.drinks.add(d);
    }

    public double getTotalPrice() {
        double totalPrice;
        for(Drink d : drinks){
          totalPrice = d.calculatePrice();
        }
        return 0;
    }
}
