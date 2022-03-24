package com.kodilla.good.patterns.challenges;

public class OrderProcessorMain {

    public static void main(String[] args) {


        User user = new User("John");
        Shoes shoes = new Shoes();
        Order order = new Order(1, user, shoes);
        OrderRequest orderRequest = new OrderRequest(order);
        MailService mailService = new MailService();
        OrderRepository orderRepository = new OrderRepository();
        ProductOrderService productOrderService = new ProductOrderService();
        OrderProcessor orderProcessor = new OrderProcessor(mailService, orderRepository, productOrderService);
        orderProcessor.process(orderRequest);

    }
}
