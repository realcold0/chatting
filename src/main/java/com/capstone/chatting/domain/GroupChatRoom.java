package com.capstone.chatting.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "GROUP_CHAT_ROOM")
public class GroupChatRoom {

    @Id @GeneratedValue
    @Column(name = "GROUP_CHAT_ROOM_ID")
    private Long id;

    private Long mid_1;
    private Long mid_2;
    private Long mid_3;
    private Long mid_4;
    private Long mid_5;
    private Long mid_6;

    private LocalDateTime createdAt;

    private Long jerryId;

    protected GroupChatRoom(){}
    public GroupChatRoom(Long mid_1, Long mid_2, Long mid_3, Long mid_4, Long mid_5, Long mid_6, Long jerryId) {
        this.mid_1 = mid_1;
        this.mid_2 = mid_2;
        this.mid_3 = mid_3;
        this.mid_4 = mid_4;
        this.mid_5 = mid_5;
        this.mid_6 = mid_6;
        this.createdAt = LocalDateTime.now();
        this.jerryId = jerryId;
    }
}
