package com.capstone.chatting.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "single_chat_room")
public class SingleChatRoom {

    @Id @GeneratedValue
    @Column(name = "single_chat_room_id")
    private Long id;

    private Long mid1;
    private Long mid2;

    private LocalDateTime created_at;

    protected SingleChatRoom(){}
    public SingleChatRoom(Long mid_1, Long mid_2) {
        this.mid1 = mid_1;
        this.mid2 = mid_2;
        this.created_at = LocalDateTime.now();
    }
}
