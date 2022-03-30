package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies(){
        //Given
        User john = new Millenials("John");
        User carl = new YGeneration("Carl");
        User paul = new ZGeneration("Paul");

        //When
        String johnIsSharing = john.share();
        System.out.println(john.getName() + " is " + johnIsSharing);
        String carlIsSharing = carl.share();
        System.out.println(carl.getName() + " is " + carlIsSharing);
        String paulIsSharing = paul.share();
        System.out.println(paul.getName() + " is " + paulIsSharing);

        //Then
        Assertions.assertEquals("Sharing something on facebook...", johnIsSharing);
        Assertions.assertEquals("Sharing something on twitter...", carlIsSharing);
        Assertions.assertEquals("Sharing something on snapchat...", paulIsSharing);
    }

    @Test
    public void testIndividualSharingStrategy(){
        //Given
        User joe = new Millenials("Joe");

        //When
        String joeIsSharing = joe.share();
        System.out.println(joe.getName() + " is " + joeIsSharing);
        joe.setSocialPublisher(new TwitterPublisher());
        joeIsSharing = joe.share();
        System.out.println(joe.getName() + " is " + joeIsSharing);

        //Then
        Assertions.assertEquals("Sharing something on twitter...", joeIsSharing);
    }
}
