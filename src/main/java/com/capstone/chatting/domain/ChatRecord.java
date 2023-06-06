package com.capstone.chatting.domain;

import com.capstone.chatting.DTO.ChatMessage;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "chat_record")
public class ChatRecord {

    @Id @GeneratedValue
    @Column(name = "chat_record_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private ChatMessage.MessageType type;

    private String roomId;

    private String sender;

    private String message;



    @Enumerated(EnumType.STRING)
    private ChatMessage.RoomType roomType;

    private LocalDateTime send_time;

    protected ChatRecord(){}

    public ChatRecord(ChatMessage.MessageType type,
                      String roomId, String sender, String message,
                      ChatMessage.RoomType roomType) {
        this.type = type;
        this.roomId = roomId;
        this.sender = sender;
        this.message = message;
        this.roomType = roomType;
        this.send_time = LocalDateTime.now();
    }
}
