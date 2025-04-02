package com.example.spring_boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoRessource {
    private final TodoRepository todoRepository;

    public TodoRessource(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping
    public void addTodo(@RequestBody Todo todo) {
        todoRepository.save(todo);
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable("id") long id) {
        return todoRepository.findById(id);
    }

    @GetMapping("/all")
    public Iterable<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
}
