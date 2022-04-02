package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BigMacTestSuite {

    @Test
    public void testBigMacNew(){
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun("normal")
                .sauce("BBQ")
                .burgers(2)
                .ingredients("onion")
                .ingredients("cheese")
                .ingredients("salad")
                .build();
        System.out.println(bigMac);
        //When
        int howManyIngredients = bigMac.getIngredients().size();
        //Then
        Assertions.assertEquals(3, howManyIngredients);
        Assertions.assertNotEquals(0, bigMac.getBurgers());
        Assertions.assertNotEquals("", bigMac.getBun());
        Assertions.assertNotEquals("", bigMac.getSauce());
    }

    @Test
    public void testBigMacNewWithoutIngredients(){
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun("normal")
                .sauce("BBQ")
                .burgers(2)
                .build();
        System.out.println(bigMac);
        //When
        int howManyIngredients = bigMac.getIngredients().size();
        //Then
        Assertions.assertEquals(0, howManyIngredients);
    }
}
