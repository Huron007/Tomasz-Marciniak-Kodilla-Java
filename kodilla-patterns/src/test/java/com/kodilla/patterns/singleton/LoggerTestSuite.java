package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void simpleLogExample(){
        logger = Logger.INSTANCE;
        logger.log("Log 1");
    }

    @Test
    void getLastLog(){
        //Given
        //When
        String log = logger.getLastLog();
        System.out.println(log);
        //Then
        Assertions.assertEquals("Log 1", log);
    }
}
