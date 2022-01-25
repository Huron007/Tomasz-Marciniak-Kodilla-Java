package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){

        //Given
        int tab[] = {6, 4, 2, 8, 10};
        //When
        double average = ArrayOperations.getAverage(tab);
        //Then
        Assertions.assertEquals(6.0, average);
    }
}
