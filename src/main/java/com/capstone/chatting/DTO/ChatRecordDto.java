package com.capstone.chatting.DTO;

import com.capstone.chatting.domain.ChatRecord;
import com.capstone.chatting.domain.RoomType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRecordDto {
    private Long roomId;
    private Long senderId;
    private String roomType;
    private String content;

    public ChatRecordDto(Long roomId, Long senderId, String roomTpye, String content) {
        this.roomId = roomId;
        this.senderId = senderId;
        this.roomType = roomTpye;
        this.content = content;
    }

    /*
    public ChatRecord createChatRecord(){
        RoomType room = roomType.equals("S") ? RoomType.S : RoomType.M;
        return new ChatRecord(roomId, senderId, room, content);
    }
    */
}
