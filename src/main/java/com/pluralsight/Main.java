package com.pluralsight;

import com.pluralsight.userinput.HomeScreen;

import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {


        AtomicReference<HomeScreen> homeScreen = new AtomicReference<>(new HomeScreen());
    }
}
