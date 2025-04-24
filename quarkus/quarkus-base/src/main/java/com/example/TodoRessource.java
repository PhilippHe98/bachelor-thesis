package com.example;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoRessource {

    private final TodoRepository todoRepository;
    public TodoRessource(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GET
    @Path("/{id}")
    public Todo getTodo(@PathParam("id") long id) {
        return todoRepository.findById(id);
    }

    @GET
    @Path("/all")
    public List<Todo> getAllTodos() {
        return todoRepository.listAll();
    }

    @POST
    public void addTodo(Todo todo) {
        todoRepository.persist(todo);
    }
}
