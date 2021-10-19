package com.iit.elasticsearchgyak;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Builder
@Data
@Document(indexName = "chat-message")
public class ChatMessage {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String message;
    @Field(type = FieldType.Text)
    private String sender;
    @Field(type = FieldType.Text)
    private String roomId;
    @Field(type = FieldType.Text)
    private String roomName;

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
