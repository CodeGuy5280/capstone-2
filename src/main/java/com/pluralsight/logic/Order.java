package com.pluralsight.logic;

import com.pluralsight.BreadType;

import java.util.ArrayList;

public class Order {


    private ArrayList<Drink> drinks = new ArrayList<>();
    //look into use of Enum BreadType
    private ArrayList<BreadType> breads = new ArrayList<>();
    private ArrayList<Chips> chips = new ArrayList<>();

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }

    public void addBread(BreadType bread) {
        this.breads.add(bread);
    }

    public void addChips(Chips chips){
        this.chips.add(chips);
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Drink drink : drinks) {
            totalPrice = drink.calculatePrice();
        }
        //for (Sandwich sandwich : sandwiches) {
        //     totalPrice += sandwich.calculatePrice();
        //for (Sandwich chips : chips) {
        //     totalPrice += chips.calculatePrice();
        return totalPrice;
    }


}
