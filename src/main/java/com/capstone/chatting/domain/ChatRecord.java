package com.capstone.chatting.domain;

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

    private Long room_id;

    private Long sender_id;

    @Enumerated(EnumType.STRING)
    private RoomType room_type;

    private String content;

    private LocalDateTime send_time;

    protected ChatRecord(){}

    public ChatRecord(Long room_id, Long sender_id, RoomType room_type, String content) {
        this.room_id = room_id;
        this.sender_id = sender_id;
        this.room_type = room_type;
        this.content = content;
        this.send_time = LocalDateTime.now();
    }
}
