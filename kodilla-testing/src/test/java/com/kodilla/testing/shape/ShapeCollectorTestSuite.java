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
        Assertions.assertTrue(collector.getFigureList().contains(circle));
    }

    @DisplayName("Sprawdza czy figura zostala usunieta z kolekcji")
    @Test
    void testCaseRemoveFigure(){
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle circle = new Circle(5);
        collector.addFigure(circle);
        //When
        boolean result = collector.removeFigure(circle);
        //Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, collector.getFigureList().size());
    }

    @DisplayName("Sprawdza czy dana figura została pobrana z listy")
    @Test
    void testCaseGetFigure(){
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle circle = new Circle(5);
        collector.addFigure(circle);
        //When
        Shape retrievedCircle = collector.getFigure(0);
        //Then
        Assertions.assertEquals(circle, retrievedCircle);
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
        Assertions.assertTrue(collector.showFigures() instanceof String);
    }
}
