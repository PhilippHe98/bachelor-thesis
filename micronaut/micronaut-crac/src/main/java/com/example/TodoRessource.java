package com.example;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.runtime.context.scope.Refreshable;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Provider;

import java.util.List;

@Refreshable
@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/todo")
public class TodoRessource {
    private final Provider<TodoRepository> todoRepositoryProvider;

    public TodoRessource(Provider<TodoRepository> todoRepositoryProvider) {
        this.todoRepositoryProvider = todoRepositoryProvider;
    }

    @Get("/{id}")
    public Todo getTodo(@PathVariable("id") long id) {
        return todoRepositoryProvider.get().findById(id).orElse(null);
    }

    @Get("/all")
    public List<Todo> getAllTodos() {
        return todoRepositoryProvider.get().findAll();
    }

    @Post
    public void addTodo(@Body Todo todo) {
        todoRepositoryProvider.get().save(todo);
    }
}
