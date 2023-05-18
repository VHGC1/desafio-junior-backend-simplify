package br.com.vitor.todolist.repository;

import br.com.vitor.todolist.domain.entities.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task getByName(String name);
}
