package com.kodilla.good.patterns.challenges.foodtodoor;

public class Order {

    private Producer producer;
    private Product product;
    private int quantity;

    public Order(final Producer producer, final Product product, final int quantity) {
        this.producer = producer;
        this.product = product;
        this.quantity = quantity;
    }

    public Producer getProducer() {
        return producer;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
