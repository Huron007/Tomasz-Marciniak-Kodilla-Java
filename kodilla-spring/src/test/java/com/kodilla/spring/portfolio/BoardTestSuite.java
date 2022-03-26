package com.kodilla.spring.portfolio;

import com.kodilla.spring.library.LibraryConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class BoardTestSuite {

    @Test
    public void toDoListExist(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);
        //When
        boolean taskListExist = context.containsBean("Task1");
        //Then
        System.out.println("Bean toDoList was found in the container: " + taskListExist);
    }
}
