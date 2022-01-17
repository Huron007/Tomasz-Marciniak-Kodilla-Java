package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OddNumbersExterminator {

    List<Integer> evenNumberList = new ArrayList<>();


    public static List<Integer> exterminate(List<Integer> numbers){
        List<Integer> evenNumberList = new ArrayList<>();
        for(Integer e: numbers){
            if(e % 2 == 0){
                evenNumberList.add(e);
            }
        }
        return evenNumberList;
    }

}
