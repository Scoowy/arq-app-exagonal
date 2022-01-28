package com.group.domain.ports;

import com.group.domain.entities.Todo;

import java.util.List;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.28.0148
 */
public interface TodoServicePort {
    public int createTodo(Todo todo);

    public Todo getTodo(Todo todo);

    public List<Todo> getTodos();

    public int updateTodo(Todo todo);

    public int deleteTodo(Todo todo);
}
