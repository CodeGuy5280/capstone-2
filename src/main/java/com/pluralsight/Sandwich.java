package com.pluralsight;


//maybe try using enum class BreadType

public class Sandwich {
    private BreadType bread;

    public Sandwich(BreadType bread){
        this.bread = bread;
    }

    public BreadType getBread(){
        return bread;
    }
}
