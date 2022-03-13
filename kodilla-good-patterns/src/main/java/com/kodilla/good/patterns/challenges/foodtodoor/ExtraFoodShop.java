package com.kodilla.good.patterns.challenges.foodtodoor;

public class ExtraFoodShop implements Producer{

    private String name = "ExtraFoodShop";

    public boolean process(Order order){
        System.out.println("Thank you for your purchase in " + order.getProducer());
        return true;
    }

    public String getName(){
        return name;
    }
}
