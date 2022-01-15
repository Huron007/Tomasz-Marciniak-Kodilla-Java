package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OddNumbersExterminator {

    private static List<Integer> evenNumberList = new ArrayList<>();


    public static List<Integer> exterminate(List<Integer> numbers){
        for(Integer e: numbers){
            if(e % 2 == 0){
                evenNumberList.add(e);
            }
        }
        return evenNumberList;
    }

}
