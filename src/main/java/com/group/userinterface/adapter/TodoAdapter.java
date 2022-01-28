package com.group.userinterface.adapter;

import com.group.domain.entities.Todo;
import com.group.domain.ports.TodoServicePort;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.28.0143
 */
public class TodoAdapter {
    private final TodoServicePort todoService;

    public TodoAdapter(TodoServicePort todoService) {
        this.todoService = todoService;
    }

    public String createTodo(Todo todo) {
        int todoResult = this.todoService.createTodo(todo);

        return "{\"message\": \"Todo created\"}";
    }
}
