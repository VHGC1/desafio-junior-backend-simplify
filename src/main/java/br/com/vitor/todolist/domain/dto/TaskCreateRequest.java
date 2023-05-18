package br.com.vitor.todolist.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class TaskCreateRequest {
    @NotBlank(message = "O nome da task não pode ser vazio.")
    private String name;

    @NotBlank(message = "A descrição não pode ser vazia.")
    private String description;

    private Boolean done = false;

    @NotNull
    @Positive(message = "Informe uma prioridade positiva.")
    private Integer Priority;
}
