package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    public Calculator calculator;

    @Test
    public void testAdd(){
        //Given
        //When
        calculator.add(1.0, 2.0);
        //Then
        //do nothing
    }

    @Test
    public void testSub(){
        //Given
        //When
        calculator.sub(5.0, 2.0);
        //Then
        //do nothing
    }

    @Test
    public void testMul(){
        //Given
        //When
        calculator.mul(2.0, 3.0);
        //Then
        //do nothing
    }

    @Test
    public void testDiv(){
        //Given
        //When
        try {
            calculator.div(10.0, 2.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Then
        //do nothing
    }
}
