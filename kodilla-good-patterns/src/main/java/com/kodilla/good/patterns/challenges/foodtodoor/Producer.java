package com.kodilla.good.patterns.challenges.foodtodoor;

public interface Producer {

    public boolean process(Order order);

    public String getName();

}
