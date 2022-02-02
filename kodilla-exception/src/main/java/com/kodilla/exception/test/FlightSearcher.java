package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearcher {

    public void findFlight(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> flightMap = new HashMap<>();
        String airport = "Airport";
        Boolean flightPossible = true;

        for (int i = 0; i < 10; i++) {
            flightPossible = !flightPossible;
            flightMap.put(airport+(i+1), flightPossible);
        }
        if (flight.getArrivalAirport() != null) {
            if (flightMap.containsKey(flight.getArrivalAirport())) {
                if (flightMap.get(flight.getArrivalAirport()) == true) {
                    System.out.println("Airport exist and travel to this airport is possible.");
                } else {
                    System.out.println("Airport exist and travel to this airport is not possible.");
                }
            } else {
                throw new RouteNotFoundException("Airport doesn't exist!");
            }
        }
    }
}
