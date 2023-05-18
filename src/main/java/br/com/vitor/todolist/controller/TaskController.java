package br.com.vitor.todolist.controller;

import br.com.vitor.todolist.domain.dto.TaskCreateRequest;
import br.com.vitor.todolist.domain.entities.model.Task;
import br.com.vitor.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return taskService.getAll();
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskCreateRequest body) {
        return taskService.createTask(body);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Task> getByName(@PathVariable("name") String name) {
        return taskService.getByName(name);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateProductById(@RequestBody Task body, @PathVariable Long id) {
        return taskService.updateTaskById(body, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTaskById(@PathVariable("id") Long id) {
        return taskService.deleteById(id);
    }

}
