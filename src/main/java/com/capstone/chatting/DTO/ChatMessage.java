package com.capstone.chatting.DTO;

import com.capstone.chatting.domain.ChatRecord;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor
public class ChatMessage {
    public enum MessageType{
        Enter,TALK,Leave
    }

    public enum RoomType{
        Single, Multi
    }

    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
    private RoomType roomType;


    public ChatRecord createChatMessage(){
        return new ChatRecord(type,roomId,sender,message,roomType);
    }
    //@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    //private LocalDateTime regDate;
}
