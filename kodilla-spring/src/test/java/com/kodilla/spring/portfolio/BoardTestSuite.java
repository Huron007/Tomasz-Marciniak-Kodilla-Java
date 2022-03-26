package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class BoardTestSuite {

    @Test
    public void toDoListExist(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        //When
        boolean taskListExist = context.containsBean("toDoList");
        //Then
        System.out.println("Bean toDoList was found in the container: " + taskListExist);
    }

    @Test
    public void inProgressListExist(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        //When
        boolean taskListExist = context.containsBean("inProgressList");
        //Then
        System.out.println("Bean inProgressList was found in the container: " + taskListExist);
    }

    @Test
    public void doneListExist(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        //When
        boolean taskListExist = context.containsBean("doneList");
        //Then
        System.out.println("Bean doneList was found in the container: " + taskListExist);
    }

    @Test
    public void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        //When
        Board board = context.getBean(Board.class);
        //Then
        board.getDoneList().add("Task1");
        board.getInProgressList().add("Task2");
        board.getToDoList().add("Task3");
        Assertions.assertEquals("Task1", board.getDoneList().toString());
        Assertions.assertEquals("Task2", board.getInProgressList().toString());
        Assertions.assertEquals("Task3", board.getToDoList().toString());
    }
}
