package com.group.infrastructure.repositories;

import com.group.domain.entities.todo.Todo;
import com.group.domain.ports.TodoRepositoryPort;
import com.group.infrastructure.databases.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.28.0212
 */
public class TodoRepositoryAdapter implements TodoRepositoryPort {
    private Connection conn;

    private static final String SQL_SELECT = "SELECT id, title, content, category, status FROM todos";
    private static final String SQL_SELECT_ONE = "SELECT id, title, content, category, status FROM todos WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO todos(id, title, content, category, status) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE todos SET title = ?, content = ?, category = ?, status = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM todos WHERE id = ?";

    public TodoRepositoryAdapter() {
    }

    public TodoRepositoryAdapter(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int save(Todo todo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;

        try {
            conn = this.conn != null ? this.conn : MySqlConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, todo.getId().toString());
            stmt.setString(2, todo.getTitle());
            stmt.setString(3, todo.getContent());
            stmt.setString(4, todo.getCategory());
            stmt.setString(5, todo.getStatus());

            rowsAffected = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            MySqlConnection.close(stmt);
            MySqlConnection.close(conn);
        }

        return rowsAffected;
    }

    @Override
    public Todo getOne(Todo todo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        Todo todoFound = null;

        try {
            conn = this.conn != null ? this.conn : MySqlConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ONE);

            stmt.setString(1, todo.getId().toString());

            res = stmt.executeQuery();
            res.next();

            todoFound = new Todo(
                    UUID.fromString(res.getString("id")),
                    res.getString("title"),
                    res.getString("content"),
                    res.getString("category"),
                    res.getString("status")
            );
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            MySqlConnection.close(res);
            MySqlConnection.close(stmt);
            MySqlConnection.close(conn);
        }

        return todoFound;
    }

    @Override
    public List<Todo> getAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        List<Todo> todos = new ArrayList<>();

        try {
            conn = this.conn != null ? this.conn : MySqlConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            res = stmt.executeQuery();

            while (res.next()) {
                Todo todo = new Todo(
                        UUID.fromString(res.getString("id")),
                        res.getString("title"),
                        res.getString("content"),
                        res.getString("category"),
                        res.getString("status")
                );
                todos.add(todo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            MySqlConnection.close(res);
            MySqlConnection.close(stmt);
            MySqlConnection.close(conn);
        }

        return todos;
    }

    @Override
    public int update(Todo todo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;

        try {
            conn = this.conn != null ? this.conn : MySqlConnection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getContent());
            stmt.setString(3, todo.getCategory());
            stmt.setString(4, todo.getStatus());
            stmt.setString(5, todo.getId().toString());

            rowsAffected = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            MySqlConnection.close(stmt);
            MySqlConnection.close(conn);
        }

        return rowsAffected;
    }

    @Override
    public int delete(Todo todo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;

        try {
            conn = this.conn != null ? this.conn : MySqlConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setString(1, todo.getId().toString());

            rowsAffected = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            MySqlConnection.close(stmt);
            MySqlConnection.close(conn);
        }

        return rowsAffected;
    }
}
