package com.todo.controller;

import com.todo.entity.Todo;
import com.todo.exception.TodoNotFoundException;
import com.todo.repository.TodoRepositoryInterface;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ("/todos"))
public class TodoController {

    @Autowired
    private TodoRepositoryInterface repo;

    @GetMapping
    public List<Todo> getAll() {
        return repo.findAll();
    }

    @GetMapping("{id}")
    public Todo getById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return repo.save(todo);
    }

    @PutMapping("{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo) {
        Todo entity = repo.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
        entity.setId(id);
        entity.setTask(todo.getTask());
        entity.setPriority(todo.getPriority());
        repo.save(entity);
        return entity;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
