package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PizzaOrderTestSuite {

    @Test
    public void basicPizzaOrderTest(){
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        //When
        BigDecimal cost = order.getCost();
        String desc = order.getDescription();
        //Then
        assertEquals(new BigDecimal(15.0), cost);
        assertEquals("Pizza with tomato sauce and cheese", desc);
    }

    @Test
    public void extraCheesePizzaOrderTest(){
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraCheesePizzaOrder(order);
        //When
        BigDecimal cost = order.getCost();
        String desc = order.getDescription();
        //Then
        assertEquals(new BigDecimal(20.0), cost);
        assertEquals("Pizza with tomato sauce and cheese + EXTRA cheese", desc);
    }

    @Test
    public void extraSalamiPizzaOrderTest(){
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraCheesePizzaOrder(order);
        order = new ExtraSalamiPizzaOrder(order);
        //When
        BigDecimal cost = order.getCost();
        String desc = order.getDescription();
        //Then
        assertEquals(new BigDecimal(27.0), cost);
        assertEquals("Pizza with tomato sauce and cheese + EXTRA cheese with additional salami", desc);
    }

    @Test
    public void bbqSaucePizzaOrderTest(){
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraCheesePizzaOrder(order);
        order = new ExtraSalamiPizzaOrder(order);
        order = new BBQSaucePizzaOrder(order);
        //When
        BigDecimal cost = order.getCost();
        String desc = order.getDescription();
        //Then
        assertEquals(new BigDecimal(30.0), cost);
        assertEquals("Pizza with tomato sauce and cheese + EXTRA cheese with additional salami + additional BBQ sauce", desc);
    }

    @Test
    public void xxlSizePizzaOrderTest(){
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraCheesePizzaOrder(order);
        order = new ExtraSalamiPizzaOrder(order);
        order = new BBQSaucePizzaOrder(order);
        order = new XXLPizzaOrder(order);
        //When
        BigDecimal cost = order.getCost();
        String desc = order.getDescription();
        //Then
        assertEquals(new BigDecimal("45.0"), cost);
        assertEquals("XXL size Pizza with tomato sauce and cheese + EXTRA cheese with additional salami + additional BBQ sauce", desc);
    }
}
