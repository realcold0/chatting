package com.capstone.chatting.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    public enum MessageType{
        Enter,TALK
    }

    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
}
