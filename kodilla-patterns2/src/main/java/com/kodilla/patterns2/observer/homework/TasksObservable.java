package com.kodilla.patterns2.observer.homework;

public interface TasksObservable {
    void registerTaskObserver(TasksObserver tasksObserver);
    void notifyTaskObservers();
    void deleteTaskObserver(TasksObserver tasksObserver);
}
