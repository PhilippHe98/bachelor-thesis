package com.example;

import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

@Singleton
public class TodoRepository {
    private final EntityManager entityManager;

    public TodoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @ReadOnly
    public Optional<Todo> findById(long id) {
        return Optional.ofNullable(entityManager.find(Todo.class, id));
    }

    @ReadOnly
    public List<Todo> findAll() {
        TypedQuery<Todo> query = entityManager.createQuery("SELECT t FROM Todo as t", Todo.class);
        return query.getResultList();
    }

    @Transactional
    public Todo save(Todo todo) {;
        entityManager.persist(todo);
        return todo;
    }
}
