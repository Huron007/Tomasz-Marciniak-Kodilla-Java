package com.kodilla.good.patterns.challenges.foodtodoor;

public class OrderInformer {

    public void inform(Order order){
        System.out.println("Order from " + order.getProducer() + " for " + order.getProduct() + " x " + order.getQuantity() + "has been completed");
    }
}
