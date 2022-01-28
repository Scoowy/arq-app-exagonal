package com.group;

import com.group.entities.Todo;

import java.util.List;
import java.util.UUID;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.27.1649
 */
public class TodoConsole {
    public static void main(String[] args) {
        TodoSqlRepository todoRepo = new TodoSqlRepository();

        List<Todo> todos = todoRepo.getTodos();

        todos.forEach(System.out::println);

        Todo todo = todoRepo.getTodo(new Todo(UUID.fromString("c092ce0d-7fb4-11ec-9ca2-b05adade7e62")));
        System.out.println(todo);

        todo.setTitle("Title changed");
        todoRepo.updateTodo(todo);

        todo = todoRepo.getTodo(new Todo(UUID.fromString("c092ce0d-7fb4-11ec-9ca2-b05adade7e62")));
        System.out.println(todo);
    }
}
