package com.group.application.services;

import com.group.domain.entities.todo.Todo;
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
        return this.todoRepository.save(todo);
    }

    @Override
    public Todo getTodo(Todo todo) {
        return this.todoRepository.getOne(todo);
    }

    @Override
    public List<Todo> getTodos() {
        return this.todoRepository.getAll();
    }

    @Override
    public int updateTodo(Todo todo) {
        return this.todoRepository.update(todo);
    }

    @Override
    public int deleteTodo(Todo todo) {
        return this.todoRepository.delete(todo);
    }

    @Override
    public int countTodos() {
        List<Todo> todos = this.todoRepository.getAll();
        return todos.size();
    }
}
