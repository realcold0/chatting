package com.capstone.chatting.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "SINGLE_CHAT_ROOM")
public class SingleChatRoom {

    @Id @GeneratedValue
    @Column(name = "SINGLE_CHAT_ROOM_ID")
    private Long id;

    private Long mid_1;
    private Long mid_2;

    protected SingleChatRoom(){}
    public SingleChatRoom(Long mid_1, Long mid_2) {
        this.mid_1 = mid_1;
        this.mid_2 = mid_2;
    }
}
