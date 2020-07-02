package com.rahul.websockets.model;

import lombok.Data;

@Data
public class RequestModel {
    private String message;
    private String fromLogin;

    public RequestModel(String message, String fromLogin) {
        this.message = message;
        this.fromLogin = fromLogin;
    }
}
