package com.kodilla.good.patterns.challenges.foodtodoor;

public class Potato implements Product {

    private String name = "Potato";

    public Potato() { }

    @Override
    public String getName(){
        return name;
    }
}
