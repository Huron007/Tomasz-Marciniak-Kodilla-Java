package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class MailService implements InformationService{

    public void inform (Order order){
        System.out.println("Dear " + order.getUser() + " your order: " + order.getProduct().getProductName() + " x "
                           + order.getQuantity() + " made at " + LocalDate.now() + " is being processed.");
    }

}
