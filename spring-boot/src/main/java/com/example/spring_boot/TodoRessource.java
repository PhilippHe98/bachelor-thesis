package com.example.spring_boot;

import org.springframework.web.bind.annotation.GetMapping;
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
    public void addNewTodo(@RequestBody String description) {
        todoRepository.save(new Todo(description));
    }

    @GetMapping("/all")
    public Iterable<Todo> getTodo() {
        return todoRepository.findAll();
    }
}
