package com.group.services;

import com.group.entities.Todo;

import java.util.List;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.19.2312
 */
public interface TodoService {
    public void createTodo(Todo todo);

    public Todo getTodo(Todo todo);

    public List<Todo> listTodos();

    public void deleteTodo(Todo todo);

    public void editTodo(Todo todo);
}
