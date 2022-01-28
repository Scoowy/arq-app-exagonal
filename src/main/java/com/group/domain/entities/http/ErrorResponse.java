package com.group.domain.entities.http;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.28.0253
 */
public class ErrorResponse extends BasicResponse {
    public ErrorResponse(int code, String message) {
        super(code, message, "ERROR");
    }
}
