package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    private Display display;

    @Autowired
    public Calculator(Display display){
        this.display = display;
    }

    public double add(double a, double b){
        double value = a + b;
        display.displayValue(value);
        return value;
    }

    public double sub(double a, double b){
        double value = a - b;
        display.displayValue(value);
        return value;
    }

    public double mul(double a, double b){
        double value = a * b;
        display.displayValue(value);
        return value;
    }

    public double div(double a, double b) throws Exception {
        if(b != 0.0){
            double value = a / b;
            display.displayValue(value);
            return value;
        } else {
            throw new Exception("Nie można dzielić przez zero!");
        }
    }
}
