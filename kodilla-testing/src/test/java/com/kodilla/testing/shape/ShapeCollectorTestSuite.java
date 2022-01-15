package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollectorTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("Sprawdza czy figura zostala dodana do kolekcji")
    @Test
    void testCaseAddFigure(){
        // Given
        ShapeCollector collector = new ShapeCollector();
        Circle circle = new Circle(5);
        // When
        collector.addFigure(circle);
        // Then
        if(collector.getFigureList().contains(circle)){
            System.out.println("Lista zawiera figure: "+circle.getShapeName());
        }
    }

    @DisplayName("Sprawdza czy figura zostala usunieta z kolekcji")
    @Test
    void testCaseRemoveFigure(){
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle circle = new Circle(5);
        //When
        collector.addFigure(circle);
        collector.removeFigure(circle);
        boolean result = collector.getFigureList().contains(circle);
        //Then
        if(result == false){
            System.out.println("Lista nie zawiera figury: "+circle.getShapeName());
        }
    }

    @DisplayName("Sprawdza czy dana figura odpowiada podanemu indexowi w liscie i ja pobiera jesli to mozliwe")
    @Test
    void testCaseGetFigure(){
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle circle = new Circle(5);
        List<Shape> comparisonList = new ArrayList<>();
        //When
        collector.getFigureList().add(0, circle);
        boolean figureExist = collector.getFigureList().contains(circle);
        comparisonList.add(0,collector.getFigure(0));
        //Then
        if(figureExist){
            System.out.println("Figura "+collector.getFigure(0).getShapeName()+" istnieje");
        }
        if(comparisonList.get(0).equals(collector.getFigure(0))){
            System.out.println("Porowywane obiekty zgadzaja sie");
        }
    }
    @DisplayName("Sprawdzy czy metoda zwraca nazwy figur w postaci stringa")
    @Test
    void testCaseShowFigures(){
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle circle = new Circle(5);
        Square square = new Square(5);
        Triangle triangle = new Triangle(5, 5);
        //When
        collector.getFigureList().add(circle);
        collector.getFigureList().add(square);
        collector.getFigureList().add(triangle);
        //Then
        System.out.println(collector.showFigures());
    }
}
