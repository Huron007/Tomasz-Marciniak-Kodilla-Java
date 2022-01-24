package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity(){
        //Given
        Country poland = new Country(new BigDecimal("100000000000")); // POLAND STRONG
        Country vatican = new Country(new BigDecimal("1"));
        Country finland  = new Country(new BigDecimal("1234567890"));
        Country uganda = new Country(new BigDecimal("4444444444444"));
        Country tunisia = new Country(new BigDecimal("234432234432"));
        Country kenya = new Country(new BigDecimal("98778978972"));
        Country northkorea = new Country(new BigDecimal("34822759285"));
        Country japan = new Country(new BigDecimal("123234590763101"));
        Country mongolia = new Country(new BigDecimal("34595734912"));
        List<Country> europeList = new ArrayList<>();
        europeList.add(poland);
        europeList.add(vatican);
        europeList.add(finland);
        Continent europe = new Continent(europeList);
        List<Country> africaList = new ArrayList<>();
        africaList.add(uganda);
        africaList.add(tunisia);
        africaList.add(kenya);
        Continent africa = new Continent(africaList);
        List<Country> asiaList = new ArrayList<>();
        asiaList.add(northkorea);
        asiaList.add(japan);
        asiaList.add(mongolia);
        Continent asia = new Continent(asiaList);
        List<Continent> continentList = new ArrayList<>();
        continentList.add(europe);
        continentList.add(africa);
        continentList.add(asia);
        World world = new World(continentList);
        //When
        BigDecimal result = world.getPeopleQuantity(world.getContinentList());
        //Then
        BigDecimal expectedResult = new BigDecimal("128182899483037");
        Assertions.assertEquals(expectedResult, result);
    }
}
