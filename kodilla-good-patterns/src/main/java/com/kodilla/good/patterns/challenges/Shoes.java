package com.kodilla.good.patterns.challenges;

public class Shoes implements Product{

    private String name = "Shoes";
    private int price = 100;

    public Shoes(){ }

    @Override
    public String getProductName(){
        return name;
    }

    @Override
    public int getProductPrice(){
        return price;
    }

}
