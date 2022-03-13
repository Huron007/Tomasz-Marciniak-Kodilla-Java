package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    public boolean process(final Order order){
        System.out.println("Processing order from user: " + order.getUser() + "\nOrder contains: " + order.getProduct().getProductName()
                           + " x " + order.getQuantity() + "\nTotal cost: " + order.getProduct().getProductPrice() * order.getQuantity());
        return true;
    }
}
