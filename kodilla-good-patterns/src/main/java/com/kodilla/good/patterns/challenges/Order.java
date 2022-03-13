package com.kodilla.good.patterns.challenges;

public class Order {

    private int quantity;
    private User user;
    private Product product;

    public Order(final int quantity, final User user, final Product product) {
        this.quantity = quantity;
        this.user = user;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }
}
