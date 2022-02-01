package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    public void ExceptionThrowingTestSuite(){
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 1.0)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0 , 1.0)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 1.5))
        );
    }
}
