package com.pavs.taskmanager.controller;

import com.pavs.taskmanager.entity.Task;
import com.pavs.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Create task for a user
    @PostMapping("/{email}")
    public Task createTask(@PathVariable String email, @RequestBody Task task) {
        return taskService.createTask(email, task);
    }

    // Get all tasks for a user
    @GetMapping("/{email}")
    public List<Task> getTasks(@PathVariable String email) {
        return taskService.getTasksForUser(email);
    }
}
