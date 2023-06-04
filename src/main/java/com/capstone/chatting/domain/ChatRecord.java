package com.capstone.chatting.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "CHAT_RECORD")
public class ChatRecord {

    @Id @GeneratedValue
    @Column(name = "CHAT_RECORD_ID")
    private Long id;

    private Long roomId;

    private Long senderId;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private String content;

    private LocalDateTime sendTime;

    protected ChatRecord(){}
    public ChatRecord(Long roomId, Long senderId, RoomType roomType, String content) {
        this.roomId = roomId;
        this.senderId = senderId;
        this.roomType = roomType;
        this.content = content;
        this.sendTime = LocalDateTime.now();
    }
}
