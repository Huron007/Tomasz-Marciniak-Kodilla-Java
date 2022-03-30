package com.kodilla.patterns.factory.tasks;

import java.util.HashMap;

public class TasksList {

    private HashMap<Task, Boolean> tasksList;

    public TasksList(){
        tasksList = new HashMap<>();
    }

    public HashMap<Task, Boolean> getTasksList() {
        return tasksList;
    }
}
