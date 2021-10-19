package com.iit.elasticsearchgyak;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ChatMessageDTO {
    @NotNull
    private String id;
    @NotNull
    private String message;
    @NotNull
    private String sender;
    @NotNull
    private String roomId;
    @NotNull
    private String roomName;

    public ChatMessage toDocument() {
        return ChatMessage.builder()
                .id(this.getId())
                .message(this.getMessage())
                .sender(this.getSender())
                .roomId(this.getRoomId())
                .roomName(this.getRoomName())
                .build();
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }
}
