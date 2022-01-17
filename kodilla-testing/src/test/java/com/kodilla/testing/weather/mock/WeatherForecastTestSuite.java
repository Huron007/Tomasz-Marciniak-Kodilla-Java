package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    public static Map<String, Double> getTemperaturesMap(){
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Warszawa 01", 23.7);
        temperaturesMap.put("Warszawa 02", 26.4);
        temperaturesMap.put("Warszawa 03", 25.1);
        temperaturesMap.put("Warszawa 04", 24.6);
        temperaturesMap.put("Warszawa 05", 25.3);
        return temperaturesMap;
    }
    @Test
    void testCalculateForecastWithMock() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }
    @DisplayName("Metoda powinna zwrocic srednia temperature z 5 spreparowanych temperatur")
    @Test
    void testAverageTemperatureWithMock(){
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(getTemperaturesMap());
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
       //When
       double averageTemperature = weatherForecast.averageTemperature();
       //Then
        Assertions.assertEquals(25.02, averageTemperature);
    }
    @DisplayName("Metoda powinna zwrocic srodkowa temperature z 5 spreparowanych temperatur")
    @Test
    void testTemperatureMedian(){
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(getTemperaturesMap());
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        double median = weatherForecast.temperatureMedian();
        //Then
        Assertions.assertEquals(25.1, median);
    }
}