package org.sambasoft.nhsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.sambasoft.nhsystem.entities.Task;
import org.sambasoft.nhsystem.entities.User;
import org.sambasoft.nhsystem.services.TaskService;
import org.sambasoft.nhsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NhSystemApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;
@BeforeAll
    public  void initDb(){
        {
            User newUser = new User("testUser@mail.com",
                    "testUser","123456");
            userService.createUser(newUser);
        }
        {
            User newAdmin = new User("testAdmin@mail.com",
                    "testAdmin","654321");
            userService.createUser(newAdmin);
        }
        Task newTask = new Task("03/01/2018",
                "00:11","11:00","You need to work today");
        User user = userService.findOne("testUser@mail.com");
        taskService.addTask(newTask,user);
    }
    @Test
    public  void  testUser(){
        User user = userService.findOne("testUser@mail.com");
        Assertions.assertNotNull(user);
        User admin = userService.findOne("testAdmin@mail.com");
        Assertions.assertEquals("testAdmin@mail.com",admin.getEmail());
    }
    @Test
    public  void  testTask(){
        User user = userService.findOne("testUser@mail.com");
        List<Task> tasks = taskService.findUserTask(user);
        Assertions.assertNotNull(tasks);
    }
}
