package com.kodilla.good.patterns.challenges.foodtodoor;

public class OrderProcessor {

    private OrderInformer orderInformer;

    public void completeOrder(Order order){
        boolean isOrderCompleted = order.getProducer().process(order);
        if(isOrderCompleted){
            orderInformer.inform(order);
            System.out.println("Order has been completed.");
        } else {
            System.out.println("Order couldn't be completed.");
        }
    }
}
