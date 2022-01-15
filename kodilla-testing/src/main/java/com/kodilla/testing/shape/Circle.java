package com.kodilla.testing.shape;

public class Circle implements Shape {

    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public float getField() {
        return (float) (Math.PI*radius*radius);
    }
}
