package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class XXLPizzaOrder extends AbstractPizzaOrderDecorator{

    public XXLPizzaOrder(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost(){
        return super.getCost().multiply(new BigDecimal(1.5));
    }

    @Override
    public String getDescription(){
        return "XXL size " + super.getDescription();
    }
}
