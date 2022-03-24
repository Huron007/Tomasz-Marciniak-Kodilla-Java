package com.kodilla.good.patterns.challenges.foodtodoor;

public class FoodToDoorMain {

    public static void main(String[] args) {

        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        HealthyShop healthyShop = new HealthyShop();
        Potato potato = new Potato();
        Water water = new Water();
        SoyBean soyBean = new SoyBean();
        Order orderOne = new Order(extraFoodShop, potato, 100);
        Order orderTwo = new Order(glutenFreeShop, soyBean, 50);
        Order orderThree = new Order(healthyShop, water, 25);
        OrderInformer orderInformer = new OrderInformer();
        OrderProcessor orderProcessor = new OrderProcessor(orderInformer);
        orderProcessor.completeOrder(orderOne);
        orderProcessor.completeOrder(orderTwo);
        orderProcessor.completeOrder(orderThree);
    }
}
