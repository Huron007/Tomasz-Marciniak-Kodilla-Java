package com.kodilla.good.patterns.challenges;

public class Water implements Product{

    private String name = "Water";
    private int price = 1;

    public Water(){ }

    @Override
    public String getProductName() {
        return name;
    }

    @Override
    public int getProductPrice() {
        return price;
    }
}
