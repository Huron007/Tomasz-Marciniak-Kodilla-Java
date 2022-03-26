package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {

    private List<String> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public void add(String task){
        tasks.add(task);
    }

    public List<String> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return tasks.stream().collect(Collectors.joining());
    }
}
