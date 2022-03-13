package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderRequest {

    private Order order;
    private LocalDate date;

    public OrderRequest(Order order){
        this.order = order;
        this.date = LocalDate.now();
    }

    public Order getOrder() {
        return order;
    }

    public LocalDate getDate() {
        return date;
    }
}
