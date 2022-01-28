package com.group.userinterface.adapter;

import com.google.gson.Gson;
import com.group.domain.entities.http.ErrorResponse;
import com.group.domain.entities.http.OkResponse;
import com.group.domain.entities.todo.Todo;
import com.group.domain.ports.TodoServicePort;
import spark.Request;
import spark.Response;

import java.util.UUID;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.28.0143
 */
public class TodoRestAdapter {
    private final Gson gson;
    private final TodoServicePort todoService;

    public TodoRestAdapter(TodoServicePort todoService) {
        this.todoService = todoService;
        this.gson = new Gson();
    }

    public String getAll(Request req, Response res) {
        res.type("application/json");
        return gson.toJson(this.todoService.getTodos());
    }

    public String addNew(Request req, Response res) {
        res.type("application/json");

        String body = req.body();
        Todo todo = gson.fromJson(body, Todo.class);

        int rowsAffected = this.todoService.createTodo(todo);

        if (rowsAffected != 0) {
            res.status(201);
            return gson.toJson(new OkResponse(201, "Todo created"));
        } else {
            res.status(404);
            return gson.toJson(new ErrorResponse(404, "Todo not created"));
        }
    }

    public String getOne(Request req, Response res) {
        res.type("application/json");

        UUID todoId = UUID.fromString(req.params("todoId"));

        Todo todo = this.todoService.getTodo(new Todo(todoId));

        if (todo != null) {
            return gson.toJson(todo);
        } else {
            res.status(404);
            return gson.toJson(new ErrorResponse(404, "Todo not found"));
        }
    }

    public String updateOne(Request req, Response res) {
        res.type("application/json");

        UUID todoId = UUID.fromString(req.params("todoId"));

        String body = req.body();
        Todo todo = gson.fromJson(body, Todo.class);
        todo.setId(todoId);

        int rowsAffected = this.todoService.updateTodo(todo);

        if (rowsAffected != 0) {
            res.status(201);
            return gson.toJson(new OkResponse(201, "Todo updated"));
        } else {
            res.status(404);
            return gson.toJson(new ErrorResponse(404, "Todo not updated"));
        }
    }

    public String deleteOne(Request req, Response res) {
        res.type("application/json");

        UUID todoId = UUID.fromString(req.params("todoId"));

        int rowsAffected = this.todoService.deleteTodo(new Todo(todoId));

        if (rowsAffected != 0) {
            res.status(201);
            return gson.toJson(new OkResponse(201, "Todo deleted"));
        } else {
            res.status(404);
            return gson.toJson(new ErrorResponse(404, "Todo not deleted"));
        }
    }
}
