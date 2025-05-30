package com.pluralsight.logic;

// import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Chips {
    //stores flavor and boolean of isSelected
    private String flavor;
    private boolean isSelected;
    //predefined Chip flavors
    private static final ArrayList<String> AVAILABLE_FLAVORS =
            new ArrayList<>(Arrays.asList("Classic", "BBQ", "Salt & Vinegar", "Sour Cream & Onion"));

    //allows access to Chip flavors by other classes
    public static ArrayList<String> getAvailableFlavors() {
        return AVAILABLE_FLAVORS;
    }

    //Chip object with a selected flavor
    public Chips(String flavor) {
        this.flavor = flavor;
        this.isSelected = true;
    }

    //default constructor if need an unselected/empty chip object
    public Chips() {
        this.flavor = " "; // Or null, or an empty string
        this.isSelected = false;
    }

    //getters and setters to access/change the chip flavor
    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public boolean isSelected() { // Getter for the boolean field
        return isSelected;
    }

    public void setSelected(boolean selected) { // Setter for the boolean field
        isSelected = selected;
    }

    //calculation of chips if selected is 1.50 otherwise return 0
    public double calculatePrice() {
        if (isSelected) {
            return 1.50; // Returns the price if selected
        } else {
            return 0.0; // Returns 0.0 if not selected
        }
    }
}