package com.kodilla.exception.test;

public class FlightRunner {

    public static void main(String[] args) {

        Flight flight = new Flight("Airport1","Airport27");
        FlightSearcher flightSearcher = new FlightSearcher();

        try {
            flightSearcher.findFlight(flight);
        } catch (RouteNotFoundException e){
            System.out.println("Airport doesn't exist, but program is still running");
        }
    }
}
