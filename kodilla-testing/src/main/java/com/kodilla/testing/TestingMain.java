package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {
        //6.1 Pierwszy Test
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        //6.2 Drugi Test

        Calculator calculator = new Calculator();

        if (calculator.add(5,10) == 15){
            System.out.println("Test zakończony pomyślnie.");
        } else {
            System.out.println("Błąd!");
        }

        if (calculator.subtractBFromA(10,5) == 5){
            System.out.println("Test zakończony pomyślnie.");
        } else {
            System.out.println("Błąd!");
        }
    }
}