package com.kodilla.good.patterns.challenges.foodtodoor;

import java.time.LocalDate;

public class GlutenFreeShop implements Producer{

    public String name = "GlutenFreeShop";

    public boolean process(Order order){
        System.out.println("Order for " + order.getProduct().getName() + " x " + order.getQuantity() + " from " + order.getProducer().getName()
                           + " made at " + LocalDate.now() + " will be delivered in about 2 days.");
        return true;
    }

    public String getName(){
        return name;
    }
}
