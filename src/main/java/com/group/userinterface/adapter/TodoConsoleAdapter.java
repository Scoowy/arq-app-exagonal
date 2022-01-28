package com.group.userinterface.adapter;

import com.group.domain.entities.todo.Todo;
import com.group.domain.ports.TodoServicePort;

import java.util.List;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.28.0353
 */
public class TodoConsoleAdapter {

    private final TodoServicePort todoService;

    public TodoConsoleAdapter(TodoServicePort todoService) {
        this.todoService = todoService;
    }

    public List<Todo> listAllTodos() {
        return this.todoService.getTodos();
    }

    public int addNewTodo(Todo todo) {
        return this.todoService.createTodo(todo);
    }

    public int getTodosCount() {
        return this.todoService.countTodos();
    }
}
