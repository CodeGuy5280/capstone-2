package com.pluralsight.logic;

public class Drink {

    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double calculatePrice(){
        if(size.equals("small")){
            return 2.0;
        }else if(size.equals("medium")){
            return 2.50;
        } else if (size.equals("large")) {
            return 3.0;
        }else {
            throw new RuntimeException("Invalid size");
        }
    }

}
