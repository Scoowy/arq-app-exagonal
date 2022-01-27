package com.group.repositories;

import com.group.entities.Todo;

import java.util.List;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.20.2214
 */
public interface TodoRepository {
    public void saveTodo(Todo todo);

    public Todo getTodo(Todo todo);

    public List<Todo> getTodos();

    public void deleteTodo(Todo todo);

    public void updateTodo(Todo todo);
}
