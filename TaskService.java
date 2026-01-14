package com.pavs.taskmanager.service;

import com.pavs.taskmanager.entity.Task;
import com.pavs.taskmanager.entity.User;
import com.pavs.taskmanager.repository.TaskRepository;
import com.pavs.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    // Create a new task for a user
    public Task createTask(String userEmail, Task task) {
        User user = userRepository.findByEmail(userEmail);
        task.setUser(user);
        return taskRepository.save(task);
    }

    // Get all tasks for a user
    public List<Task> getTasksForUser(String userEmail) {
        User user = userRepository.findByEmail(userEmail);
        return taskRepository.findByUser(user);
    }
}
