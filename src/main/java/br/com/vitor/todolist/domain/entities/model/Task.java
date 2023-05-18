package br.com.vitor.todolist.domain.entities.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;


    private String description;
    private Boolean done;
    private Integer Priority;
}
