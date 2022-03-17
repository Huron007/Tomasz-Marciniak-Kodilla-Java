package com.kodilla.good.patterns.challenges.airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class FlightDatabase {

    private HashMap<String, List<String>> flightDataBase = new HashMap<>();


    public FlightDatabase(){
        List<String> flightsFromWarsaw = new ArrayList<>();
        List<String> flightsFromCracow = new ArrayList<>();
        List<String> flightsFromPoznan = new ArrayList<>();
        List<String> flightsFromGdansk = new ArrayList<>();
        List<String> flightsFromWroclaw = new ArrayList<>();
        flightsFromWarsaw.add("Gdansk");
        flightsFromWarsaw.add("Krakow");
        flightsFromCracow.add("Poznan");
        flightsFromCracow.add("Wroclaw");
        flightsFromPoznan.add("Warszawa");
        flightsFromPoznan.add("Wroclaw");
        flightsFromGdansk.add("Wroclaw");
        flightsFromGdansk.add("Krakow");
        flightsFromWroclaw.add("Krakow");
        flightsFromWroclaw.add("Warszawa");
        flightDataBase.put("Warszawa", flightsFromWarsaw);
        flightDataBase.put("Krakow", flightsFromCracow);
        flightDataBase.put("Wroclaw", flightsFromWroclaw);
        flightDataBase.put("Poznan", flightsFromPoznan);
        flightDataBase.put("Gdansk", flightsFromGdansk);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDatabase that = (FlightDatabase) o;
        return Objects.equals(flightDataBase, that.flightDataBase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightDataBase);
    }

    public HashMap<String, List<String>> getFlightDataBase() {
        return flightDataBase;
    }

    public void show(){
        for(String i : flightDataBase.keySet()){
            System.out.println("key: " + i + " value: " + flightDataBase.get(i));
        }
    }
}
