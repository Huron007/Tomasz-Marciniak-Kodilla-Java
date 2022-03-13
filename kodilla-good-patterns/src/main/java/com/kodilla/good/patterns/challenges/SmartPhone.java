package com.kodilla.good.patterns.challenges;

public class SmartPhone implements Product{

    private String name = "Smartphone";
    private int price = 1000;

    public SmartPhone(){ }

    @Override
    public String getProductName(){
        return name;
    }

    @Override
    public int getProductPrice(){
        return price;
    }

}
