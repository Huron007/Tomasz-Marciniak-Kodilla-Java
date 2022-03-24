package com.kodilla.good.patterns.challenges.foodtodoor;

public class Water implements Product{

    private String name = "Water";

    public Water() { }

    @Override
    public String getName(){
        return name;
    }
}
