package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPINGTASK = "Shopping Task";
    public static final String PAINTINGTASK = "Painting Task";
    public static final String DRIVINGTASK = "Driving Task";

    public final Task makeTask(final String taskName){
        switch (taskName){
            case SHOPPINGTASK:
                return new ShoppingTask("Buy a banana", "Banana", 2.0);
            case PAINTINGTASK:
                return new PaintingTask("Painting", "Blue", "Room");
            case DRIVINGTASK:
                return new DrivingTask("Drive to work", "Work", "Car");
            default:
                return null;
        }
    }
}
