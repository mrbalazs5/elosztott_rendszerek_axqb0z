package com.example.demo;

public class RestException extends Exception {
    public RestException() {
        super("Error.");
    }

    public RestException(String message) {
        super(message);
    }
}
