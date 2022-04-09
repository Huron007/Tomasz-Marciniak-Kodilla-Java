package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.TaskList;
import com.kodilla.hibernate.taskslist.dao.TaskListDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private final static String LIST_NAME = "test name";
    private final static String DESCRIPTION = "test description";

    @Test
    public void testFindByListName(){
        //Given
        TaskList taskList = new TaskList(LIST_NAME, DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();
        Optional<TaskList> readTaskList = taskListDao.findById(id);
        Assertions.assertTrue(readTaskList.isPresent());

        //Cleanup
        taskListDao.deleteById(id);
    }
}
