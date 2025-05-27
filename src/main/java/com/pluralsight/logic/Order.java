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
        double totalPrice = 0.0;
        for(Drink drink : drinks){
          totalPrice = drink.calculatePrice();
        }
        //for (Sandwich sandwich : sandwiches) {
            //     totalPrice += sandwich.calculatePrice();
        //for (Sandwich chips : chips) {
            //     totalPrice += chips.calculatePrice();
        return totalPrice;
    }


}
