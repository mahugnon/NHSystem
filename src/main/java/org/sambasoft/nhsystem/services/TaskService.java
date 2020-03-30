package org.sambasoft.nhsystem.services;

import org.sambasoft.nhsystem.entities.Task;
import org.sambasoft.nhsystem.entities.User;
import org.sambasoft.nhsystem.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public void  addTask(Task task, User user){
        task.setUser(user);
        taskRepository.save(task);
    }
    public List<Task> findUserTask(User user){
        return taskRepository.findByUser(user);
    }
}
