package br.com.vitor.todolist.service;

import br.com.vitor.todolist.domain.dto.TaskCreateRequest;
import br.com.vitor.todolist.domain.entities.model.Task;
import br.com.vitor.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(taskRepository.findAll());
    }

    public ResponseEntity<Task> createTask(TaskCreateRequest body) {
        Task task = new Task();

        task.setName(body.getName());
        task.setDescription(body.getDescription());
        task.setDone(body.getDone());
        task.setDescription(body.getDescription());
        task.setPriority(body.getPriority());

        Task saveTask = taskRepository.save(task);

        return ResponseEntity.ok(saveTask);
    }

    public ResponseEntity<Task> getByName(String name) {
        Task response = taskRepository.getByName(name);

        if (response == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Task não encontrada");
        }

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Task> updateTaskById(Task body ,Long id) {
        Optional<Task> optTask = taskRepository.findById(id);
        Task task = optTask
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task não encontrada"));

        task.setName(body.getName());
        task.setDescription(body.getDescription());
        task.setDone(body.getDone());
        task.setPriority(body.getPriority());

        Task savedTask = taskRepository.save(task);

        return ResponseEntity.ok(savedTask);
    }

    public String deleteById(Long id) {
        Optional<Task> optTask = taskRepository.findById(id);
        Task task = optTask
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task não encontrada"));

        taskRepository.deleteById(id);

        return "Deleted";
    }
}
