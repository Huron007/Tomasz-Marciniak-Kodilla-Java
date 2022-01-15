package com.kodilla.testing.shape;

public interface Shape {

    public default String getShapeName(){
        return "";
    }

    public default float getField(){
        return 0;
    }
}
