package com.group.domain.entities.http;

/**
 * Class
 *
 * @author Scoowy
 * @version 2022.01.28.0254
 */
public class OkResponse extends BasicResponse {
    public OkResponse(int code, String message) {
        super(code, message, "OK");
    }
}
