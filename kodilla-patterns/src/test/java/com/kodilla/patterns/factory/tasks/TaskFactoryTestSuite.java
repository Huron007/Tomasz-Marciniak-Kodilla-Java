package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskFactoryTestSuite {

    private TasksList tasksList = new TasksList();
    private static TaskFactory taskFactory = new TaskFactory();

    @Test
    public void testShoppingTask(){
        //Given
        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPINGTASK);
        shoppingTask.executeTask();
        tasksList.getTasksList().put(shoppingTask, shoppingTask.isTaskExecuted());
        //Then
        Assertions.assertEquals("Buy a banana", shoppingTask.getTaskName());
        Assertions.assertTrue(tasksList.getTasksList().get(shoppingTask));
    }

    @Test
    public void testPaintingTask(){
        //Given
        //When
        Task paintingTask = taskFactory.makeTask(TaskFactory.PAINTINGTASK);
        paintingTask.executeTask();
        tasksList.getTasksList().put(paintingTask, paintingTask.isTaskExecuted());
        //Then
        Assertions.assertEquals("Painting", paintingTask.getTaskName());
        Assertions.assertTrue(tasksList.getTasksList().get(paintingTask));
    }

    @Test
    public void testDrivingTask(){
        //Given
        //When
        Task drivingTask = taskFactory.makeTask(TaskFactory.DRIVINGTASK);
        drivingTask.executeTask();
        tasksList.getTasksList().put(drivingTask, drivingTask.isTaskExecuted());
        //Then
        Assertions.assertEquals("Drive to work", drivingTask.getTaskName());
        Assertions.assertTrue(tasksList.getTasksList().get(drivingTask));
    }
}
