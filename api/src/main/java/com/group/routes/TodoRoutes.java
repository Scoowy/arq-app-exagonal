package com.group.routes;

import com.group.application.services.TodoService;
import com.group.infrastructure.repositories.TodoRepositoryAdapter;
import com.group.userinterface.adapter.TodoRestAdapter;
import spark.RouteGroup;
import spark.Spark;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.28.0313
 */
public class TodoRoutes implements RouteGroup {
    private final TodoRestAdapter todoCtrl = new TodoRestAdapter(new TodoService(new TodoRepositoryAdapter()));

    @Override
    public void addRoutes() {
        Spark.get("", todoCtrl::getAll);
        Spark.post("", todoCtrl::addNew);

        Spark.path("/:todoId", () -> {
            Spark.get("", todoCtrl::getOne);
            Spark.put("", todoCtrl::updateOne);
            Spark.delete("", todoCtrl::deleteOne);
        });
    }
}
