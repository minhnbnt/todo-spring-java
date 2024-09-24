package com.minhnbnt.todo.controllers;

import com.minhnbnt.todo.dtos.TodoDto;
import com.minhnbnt.todo.models.Todo;
import com.minhnbnt.todo.repositories.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository repository;

    @GetMapping
    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable long id) {
        return repository.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void newTodo(@RequestBody TodoDto dto) {

        var todo = new Todo();
        todo.setDescription(dto.description());

        repository.save(todo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeDescription(
            @PathVariable long id,
            @RequestBody TodoDto dto
    ) {

        var target = repository.getReferenceById(id);

        target.setDescription(dto.description());
        repository.save(target);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void completeTodo(@PathVariable long id) {

        var target = repository.getReferenceById(id);

        target.setIsCompleted(true);
        repository.save(target);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable long id) {
        var target = repository.getReferenceById(id);
        repository.delete(target);
    }
}
