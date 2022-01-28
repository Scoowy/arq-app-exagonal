package com.group.application.services;

import com.group.domain.entities.Todo;
import com.group.domain.ports.TodoRepositoryPort;
import com.group.domain.ports.TodoServicePort;

import java.util.List;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.28.0205
 */
public class TodoService implements TodoServicePort {

    private final TodoRepositoryPort todoRepository;

    public TodoService(TodoRepositoryPort todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public int createTodo(Todo todo) {
        return 0;
    }

    @Override
    public Todo getTodo(Todo todo) {
        return null;
    }

    @Override
    public List<Todo> getTodos() {
        return null;
    }

    @Override
    public int updateTodo(Todo todo) {
        return 0;
    }

    @Override
    public int deleteTodo(Todo todo) {
        return 0;
    }
}
