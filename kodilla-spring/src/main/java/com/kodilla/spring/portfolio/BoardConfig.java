package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    TaskList toDoList;
    @Autowired
    TaskList inProgressList;
    @Autowired
    TaskList doneList;

    @Bean
    public Board Board() {
        return new Board(toDoList(), inProgressList(), doneList());
    }

    @Bean
    @Scope("prototype")
    public TaskList toDoList(){
        return  new TaskList();
    }

    @Bean
    @Scope("prototype")
    public TaskList inProgressList(){
        return new TaskList();
    }

    @Bean
    @Scope("prototype")
    public TaskList doneList(){
        return new TaskList();
    }
}
