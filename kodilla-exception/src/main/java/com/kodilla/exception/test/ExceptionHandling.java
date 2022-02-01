package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) throws Exception {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(1.0, 1.5);
        } catch (Exception e){
            System.out.println("Exception has been thrown!");
        } finally {
            System.out.println("Just sitting here...");
        }
    }
}
