package com.kodilla.testing.collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }


    @DisplayName("Jeśli lista jest pusta wyskoczy komunikat o błędzie.")

    @Test
    public void testOddNumbersExterminatorEmptyList(){
        List<Integer> listOne = new ArrayList<>();

        Random rnd = new Random();

        for(int i = 0; i < 10; i++){
            listOne.add(rnd.nextInt(100));
        }
        if(listOne.isEmpty()){
            System.out.println("Błąd! Lista jest pusta.");
        }
    }

    @DisplayName("Jeśli lista zawiera cyfry nieparzystę wyskoczy komunikat o błędzie.(Wersja z zapełnieniem listy pętlą for.")

    @Test
    public void testOddNumbersExterminatorNormalList1(){
        List<Integer> listOne = new ArrayList<>();

        Random rnd = new Random();

        for(int i = 0; i < 10; i++){
            listOne.add(rnd.nextInt(100));
        }
        for(Integer e: OddNumbersExterminator.exterminate(listOne)){
            if(e % 2 != 0){
                System.out.println("Błąd! Lista zawiera cyfre nieparzystą.");
            }
        }
    }
    @DisplayName("Jeśli lista zawiera cyfry nieparzystę wyskoczy komunikat o błędzie.(Wersja z Arrays.asList())")

    @Test
    public void testOddNumbersExterminatorNormalList2(){
        List<Integer> listOne = new ArrayList<>();

        Integer a[] = new Integer[] { 2, 5, 6, 11, 13, 14, 16, 23, 44, 67, 86};

        listOne = Arrays.asList(a);

        for(Integer e: OddNumbersExterminator.exterminate(listOne)){
            if(e % 2 != 0){
                System.out.println("Błąd! Lista zawiera cyfre nieparzystą.");
            }
        }
    }
}
