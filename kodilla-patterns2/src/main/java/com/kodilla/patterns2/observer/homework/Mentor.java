package com.kodilla.patterns2.observer.homework;

import lombok.Getter;

@Getter
public class Mentor implements TasksObserver{

    private final String name;
    private int taskCount;

    public Mentor(String name){
        this.name = name;
    }

    @Override
    public void update(StudentTasks studentTasks){
        System.out.println("Mentor " + name + " has total of " + studentTasks.getTaskList().size() + " from " + studentTasks.getName() + " to check.");
        taskCount++;
    }
}
