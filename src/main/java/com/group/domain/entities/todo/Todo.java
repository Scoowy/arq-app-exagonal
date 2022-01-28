package com.group.domain.entities.todo;

import java.util.StringJoiner;
import java.util.UUID;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.28.0136
 */
public class Todo {
    private UUID id;
    private String title;
    private String content;
    private String category;
    private String status;

    public Todo(UUID id) {
        this.id = id;
    }

    public Todo(String id) {
        this.id = UUID.fromString(id);
    }

    public Todo(UUID id, String title, String content, String category, String status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Todo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("title='" + title + "'")
                .add("content='" + content + "'")
                .add("category='" + category + "'")
                .add("status='" + status + "'")
                .toString();
    }
}
