package com.kodilla.good.patterns.challenges.foodtodoor;

public class OrderInformer {

    public void inform(Order order){
        System.out.println("Order from " + order.getProducer().getName() + " for " + order.getProduct().getName() + " x " + order.getQuantity() + " has been completed.");
    }
}
