package com.pluralsight.logic;

import com.pluralsight.BreadType;

import java.util.ArrayList;

public class Order {
//look into use of Enum BreadType

    private ArrayList<Drink> drinks = new ArrayList<>();

    private ArrayList<Sandwich> sandwich = new ArrayList<>();
    private ArrayList<Chips> chips = new ArrayList<>();

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }

    public void addSandwich(Sandwich sandwich) {
        this.sandwich.add(sandwich);
    }

    public void addChips(Chips chips){
        this.chips.add(chips);
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Drink drink : drinks) {
            totalPrice += drink.calculatePrice();
        }
        for (Sandwich sandwich : sandwich) {
            totalPrice += sandwich.calculatePrice();
        }
        for (Chips chips : chips) {
            totalPrice += chips.calculatePrice();
        }
        return totalPrice;
    }


}
