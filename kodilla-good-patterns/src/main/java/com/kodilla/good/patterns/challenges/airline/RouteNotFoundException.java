package com.kodilla.good.patterns.challenges.airline;

public class RouteNotFoundException extends Exception {

    public RouteNotFoundException (final String message){
        super(message);
    }
}
