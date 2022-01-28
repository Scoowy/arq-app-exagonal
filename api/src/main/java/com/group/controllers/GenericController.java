package com.group.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.group.domain.entities.http.ErrorResponse;
import spark.Request;
import spark.Response;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.28.0305
 */
public class GenericController {
    Gson gson;
    GsonBuilder builder = new GsonBuilder();

    public GenericController() {
        this.gson = builder.create();
    }

    public String resourceNotFound(Request req, Response res) {
        res.type("application/json");
        return gson.toJson(new ErrorResponse(404, "Resource not found"));
    }

    public String unknownError(Request req, Response res) {
        res.type("application/json");
        return gson.toJson(new ErrorResponse(500, "Unknown error, see the logs"));
    }
}
