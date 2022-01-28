package com.group.ui;

import com.group.domain.entities.todo.Todo;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.28.0405
 */
public class UiPresenter {
    private static final Scanner input = new Scanner(System.in);

    public static void showMainMenu() {
        String menu = """
                === MENU ===
                1.- Nuevo TODO
                2.- Ver TODOs
                3.- Salir""";

        System.out.println(menu);
    }

    public static int getResponseBetween(int min, int max) {
        int response = -1;

        do {
            System.out.print("Selección: ");

            try {
                response = input.nextInt();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                input.next();
            }

        } while (response < min || response > max);

        return response;
    }

    public static void presentTodos(List<Todo> todos) {
        System.out.printf("=== TODOS (%d) ===\n", todos.size());

        todos.forEach((todo) -> {
            String todoStr = """
                    ID: %s
                    Title: %s
                    Content: %s
                    Category: %s
                    Status: %s
                    """.formatted(todo.getId(), todo.getTitle(), todo.getContent(), todo.getCategory(), todo.getStatus());
            System.out.println(todoStr);
        });

        System.out.println("=== TODOS ===\n");
    }

    public static Todo getTodoData() {
        System.out.println("=== New TODO ===");

        UUID id = UUID.randomUUID();
        String title = getData("Title");
        String content = getData("Content");
        String category = getData("Category");
        String status = "pending";

        return new Todo(id, title, content, category, status);
    }

    public static String getData(String title) {
        String res;

        do {
            System.out.printf("%s: ", title);
            res = input.nextLine();
        } while (res == null || res.length() == 0);

        return res;
    }
}
