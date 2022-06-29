package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTaskTestSuite {

    @Test
    public void tasksObserverTest(){
        //Given
        StudentTasks urgentStudentTasks = new UrgentStudentTasks();
        StudentTasks regularStudentTasks = new RegularStudentTasks();
        StudentTasks regularStudentTasks2 = new RegularStudentTasks();
        Mentor john = new Mentor("John");
        Mentor paul = new Mentor("Paul");
        urgentStudentTasks.registerTaskObserver(john);
        regularStudentTasks.registerTaskObserver(john);
        regularStudentTasks2.registerTaskObserver(paul);
        regularStudentTasks.registerTaskObserver(paul);
        //When
        urgentStudentTasks.addTask(new Task("Task1", "Test"));
        urgentStudentTasks.addTask(new Task("Task2", "Test"));
        regularStudentTasks.addTask(new Task("Task3", "Test"));
        regularStudentTasks.addTask(new Task("Task4", "Test"));
        regularStudentTasks.addTask(new Task("Task5", "Test"));
        regularStudentTasks2.addTask(new Task("Task6", "Test"));
        regularStudentTasks2.addTask(new Task("Task7", "Test"));
        regularStudentTasks2.addTask(new Task("Task8", "Test"));
        regularStudentTasks2.addTask(new Task("Task9", "Test"));
        //Then
        assertEquals(5, john.getTaskCount());
        assertEquals(7, paul.getTaskCount());
    }
}
