package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private int baseLength;
    private int height;

    public Triangle(int baseLength, int height) {
        this.baseLength = baseLength;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public float getField() {
        return height*baseLength/2;
    }
}
