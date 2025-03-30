package com.rest.server.graphql.responses;

public class LoginResponse {
    private String userId;
    private String message;

    public LoginResponse(String userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }
}
