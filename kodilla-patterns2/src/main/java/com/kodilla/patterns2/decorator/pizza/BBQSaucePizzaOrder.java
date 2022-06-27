package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BBQSaucePizzaOrder extends AbstractPizzaOrderDecorator {

    public BBQSaucePizzaOrder(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(3.0));
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " + additional BBQ sauce";
    }
}
