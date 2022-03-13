package com.kodilla.good.patterns.challenges.foodtodoor;

public class HealthyShop implements Producer{

    private String name = "HealthyFood";

    public boolean process(Order order){
        System.out.println("Fresh and healthy " + order.getProduct().getName() + " from " + order.getProducer().getName() + " will be at your door soon.");
        return true;
    }

    public String getName(){
        return name;
    }
}
