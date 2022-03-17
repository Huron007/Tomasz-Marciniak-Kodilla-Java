package com.kodilla.good.patterns.challenges.airline;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ConnectingFlight {

    private FlightsFrom flightsFrom;
    private FlightsTo flightsTo;

    public ConnectingFlight(FlightsTo flightsTo, FlightsFrom flightsFrom){
        this.flightsFrom = flightsFrom;
        this.flightsTo = flightsTo;
    }

    public List<String> showFlights(@NotNull String departure,@NotNull String destination) throws RouteNotFoundException{
        List<String> compareDeparture = flightsFrom.showFlights(departure);
        List<String> compareDestination = flightsTo.showFlights(destination);
        compareDeparture.retainAll(compareDestination);
        if(!compareDeparture.isEmpty()){
            return compareDeparture;
        } else {
            throw new RouteNotFoundException("Route doesn't exist!");
        }
    }
}
