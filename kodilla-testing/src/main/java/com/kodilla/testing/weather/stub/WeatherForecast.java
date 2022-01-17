package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double averageTemperature(){
        double averageTemperature = 0;
        int counter = 0;

        for (Map.Entry<String, Double> e : temperatures.getTemperatures().entrySet()) {
            averageTemperature += e.getValue();
            counter++;
        }
        return averageTemperature/counter;
    }

    public double temperatureMedian(){
        List<Double> temperatureList = new ArrayList<>();
        double median =0;

        for(Map.Entry<String, Double> e : temperatures.getTemperatures().entrySet()){
            temperatureList.add(e.getValue());
        }
        Collections.sort(temperatureList);
        median = temperatureList.get(temperatureList.size()/2);
        return median;
    }
}