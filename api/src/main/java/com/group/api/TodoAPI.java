package com.group.api;

import com.group.controllers.GenericController;
import com.group.routes.TodoRoutes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.28.0300
 */
public class TodoAPI {
    public final static Logger logger = LoggerFactory.getLogger(TodoAPI.class);

    public static void main(String[] args) {
        // Handler the error at init the Jetty Server
        Spark.initExceptionHandler(e -> {
            logger.error("[INIT ERROR]", e);
            System.exit(100);
        });

        // Set the port
        Spark.port(getPort());
        // Init manually the server
        Spark.init();

        // Adding the generic controllers
        GenericController genericCtrl = new GenericController();

        // Todo: Return JSON of the API
        Spark.get("/", (request, response) -> "TODO RESTful API");

        // Routes of API
        Spark.path("/api", () -> {
            Spark.path("/todos", new TodoRoutes());
        });

        // Default route in not found resource
        Spark.notFound(genericCtrl::resourceNotFound);

        // Default route in unknown error occurring
        Spark.internalServerError(genericCtrl::unknownError);
    }

    static int getPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 8080;
    }
}
