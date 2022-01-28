package com.group.domain.ports;

import com.group.domain.entities.todo.Todo;

import java.util.List;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.28.0206
 */
public interface TodoRepositoryPort {
    public int save(Todo todo);

    public Todo getOne(Todo todo);

    public List<Todo> getAll();

    public int update(Todo todo);

    public int delete(Todo todo);
}
