package com.pluralsight.logic;

// import java.util.ArrayList;

public class Chips {

    private String flavor;
    private boolean isSelected; // Renamed for clarity and to avoid conflict

    public Chips(String flavor) {
        this.flavor = flavor;
        this.isSelected = true;
    }

    //default constructor if need an unselected/empty chip object
//    public Chips() {
//        this.flavor = " "; // Or null, or an empty string
//        this.isSelected = false;
//    }


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

    public double calculatePrice() {
        if (isSelected) {
            return 1.50; // Returns the price if selected
        } else {
            return 0.0; // Returns 0.0 if not selected
        }
    }
}