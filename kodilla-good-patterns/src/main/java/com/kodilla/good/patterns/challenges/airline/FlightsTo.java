package com.kodilla.good.patterns.challenges.airline;

import java.util.List;
import java.util.stream.Collectors;

public class FlightsTo {

    private FlightDatabase flightDatabase;

    public FlightsTo(FlightDatabase flightDatabase){
        this.flightDatabase = flightDatabase;
    }

    public List<String> showFlights(String destination) throws RouteNotFoundException{
        if(flightDatabase.getFlightDataBase().entrySet().stream().map(e -> e.getValue()).anyMatch(s -> s.contains(destination))) {
            List<String> flights = flightDatabase.getFlightDataBase().entrySet().stream()
                    .filter(e -> e.getValue().contains(destination))
                    .map(x -> x.getKey())
                    .collect(Collectors.toList());
            return flights;
        } else {
            throw new RouteNotFoundException("Airport doesn't exist!");
        }
    }
}
