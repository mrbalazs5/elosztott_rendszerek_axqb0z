package com.example.demo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MessageDTO {
    @NotNull
    private String message;
    @NotNull
    private String from;
    @NotNull
    private String room;

    public String getMessage() {
        return message;
    }

    public String getRoom() {
        return room;
    }

    public String getFrom() {
        return from;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
