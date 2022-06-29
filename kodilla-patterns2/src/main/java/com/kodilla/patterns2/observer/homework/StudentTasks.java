package com.kodilla.patterns2.observer.homework;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StudentTasks implements TasksObservable {
    private final String name;
    private List<Task> taskList;
    private List<TasksObserver> tasksObservers;

    public StudentTasks(String name){
        this.name = name;
        taskList = new ArrayList<>();
        tasksObservers = new ArrayList<>();
    }

    public void addTask(Task task){
        taskList.add(task);
        notifyTaskObservers();
    }

    @Override
    public void registerTaskObserver(TasksObserver tasksObserver) {
        tasksObservers.add(tasksObserver);
    }

    @Override
    public void notifyTaskObservers() {
        for (TasksObserver tasksObserver : tasksObservers) {
            tasksObserver.update(this);
        }
    }

    @Override
    public void deleteTaskObserver(TasksObserver tasksObserver) {
        tasksObservers.remove(tasksObserver);
    }
}
