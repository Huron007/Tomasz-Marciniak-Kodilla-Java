package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.collection.OddNumbersExterminator;
import com.kodilla.testing.user.SimpleUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestingMain {

    public static void main(String[] args) {

        List<Integer> listOne = new ArrayList<>();

        Random rnd = new Random();

        for(int i = 0; i < 10; i++){
            listOne.add(rnd.nextInt(100));
        }
        System.out.println(listOne);

       System.out.println(OddNumbersExterminator.exterminate(listOne));

    }
}