package com.pluralsight.logic;

import java.util.ArrayList;

public class Order {


    private ArrayList<Drink> drinks = new ArrayList<>();
    private ArrayList<String> breads = new ArrayList<>();

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }
    public void addBread(String bread) {
        this.breads.add(bread);
    }

    public double getTotalPrice() {
        double totalPrice;
        for(Drink drink : drinks){
          totalPrice = drink.calculatePrice();
        }
        return 0;
    }


}
