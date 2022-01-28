package com.group.console;

import com.group.application.services.TodoService;
import com.group.domain.entities.todo.Todo;
import com.group.infrastructure.repositories.TodoRepositoryAdapter;
import com.group.ui.UiPresenter;
import com.group.userinterface.adapter.TodoConsoleAdapter;

import java.util.List;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.27.1649
 */
public class TodoConsole {
    public static void main(String[] args) {
        TodoConsoleAdapter todoCtrl = new TodoConsoleAdapter(new TodoService(new TodoRepositoryAdapter()));
        boolean exit = false;

        do {
            UiPresenter.showMainMenu();

            int res = UiPresenter.getResponseBetween(1, 3);

            switch (res) {
                case 1 -> {
                    Todo todo = UiPresenter.getTodoData();
                    int added = todoCtrl.addNewTodo(todo);

                    if (added != 0) {
                        System.out.println("TODO created successfully.");
                    } else {
                        System.out.println("Error trying to create TODO.");
                    }
                }
                case 2 -> UiPresenter.presentTodos(todoCtrl.listAllTodos());
                case 3 -> exit = true;
            }
        } while (!exit);

        System.out.println("Saliendo...");
    }
}
