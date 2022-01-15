package com.kodilla.testing.shape;

public class Square implements Shape{

    private int sideLength;

    public Square(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public float getField() {
        return sideLength^2;
    }
}
