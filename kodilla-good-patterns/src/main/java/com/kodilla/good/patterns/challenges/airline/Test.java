package com.kodilla.good.patterns.challenges.airline;

public class Test {

    public static void main(String[] args) {

        FlightDatabase flightDatabase = new FlightDatabase();
        FlightsFrom flightsFrom = new FlightsFrom(flightDatabase);
        FlightsTo flightsTo = new FlightsTo(flightDatabase);
        ConnectingFlight connectingFlight = new ConnectingFlight(flightsTo, flightsFrom);

        try {
            connectingFlight.showFlights("Warszawa", "Wroclaw").forEach(s -> System.out.println(s));
        } catch (RouteNotFoundException e) {
            e.printStackTrace();
        }
        //flightsFrom.showFlights("Kraków").forEach(s -> System.out.println(s));

    }
}
