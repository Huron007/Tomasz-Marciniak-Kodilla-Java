package com.kodilla.good.patterns.challenges.airline;

import java.util.List;
import java.util.stream.Collectors;

public class FlightsFrom {

    private FlightDatabase flightDatabase;

    public FlightsFrom(FlightDatabase flightDatabase){
        this.flightDatabase = flightDatabase;
    }

    public List<String> showFlights(String departure) throws RouteNotFoundException {
        if(flightDatabase.getFlightDataBase().containsKey(departure)) {
            List<String> flights = flightDatabase.getFlightDataBase().entrySet().stream()
                    .filter(flight -> flight.getKey().equals(departure))
                    .flatMap(e -> e.getValue().stream())
                    .collect(Collectors.toList());
            return flights;
        }
        else {
            throw new RouteNotFoundException("Airport doesn't exist!");
        }
    }
}
