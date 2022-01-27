package com.group;

import com.group.entities.Todo;
import com.group.repositories.TodoRepository;

import java.util.List;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.27.1101
 */
public class TodoSqlRepository implements TodoRepository {


    @Override
    public void saveTodo(Todo todo) {

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
    public void deleteTodo(Todo todo) {

    }

    @Override
    public void updateTodo(Todo todo) {

    }
}
