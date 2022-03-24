package com.kodilla.good.patterns.challenges.foodtodoor;

public class SoyBean implements Product {

    private String name = "Soy Bean";

    public SoyBean() { }

    @Override
    public String getName(){
        return name;
    }
}
