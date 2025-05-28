package com.pluralsight.logic;

import java.util.ArrayList;


public class Order {
//look into use of Enum BreadType

    private ArrayList<Sandwich> sandwich = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private ArrayList<Chips> chips = new ArrayList<>();

    //constructor for each sandwich, drink, and chip
    public Order(){
        this.sandwich = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    //adding sandwich, drink, and chips to ArrayLists
    public void addSandwich(Sandwich sandwich) {
        this.sandwich.add(sandwich);
    }

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }

    public void addChips(Chips chips){
        this.chips.add(chips);
    }

    //total price calculation
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

    //getters to generate receipt
    public ArrayList<Sandwich> getSandwiches() {
        return sandwich;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Chips> getChips() {
        return chips;
    }
}
