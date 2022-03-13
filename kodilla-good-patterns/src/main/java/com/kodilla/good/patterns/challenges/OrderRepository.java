package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.util.HashMap;

public class OrderRepository {

    private HashMap<LocalDate, Order> orderRepository = new HashMap<>();

    public OrderRepository() { }

    public void addToRepository(Order order){
        orderRepository.put(LocalDate.now(), order);
    }

    public void showRepository(){
        System.out.println(orderRepository);
    }
}
