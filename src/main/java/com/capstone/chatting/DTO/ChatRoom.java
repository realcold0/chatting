package com.capstone.chatting.DTO;

import com.capstone.chatting.Service.ChatRoomService;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Getter
public class ChatRoom {
    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    @Builder
    public ChatRoom(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    public void handlerActions(WebSocketSession session, ChatMessage chatMessage, ChatRoomService chatRoomService) {
        if (chatMessage.getType().equals(ChatMessage.MessageType.Enter)) {
            sessions.add(session);
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
        }
        sendMessage(chatMessage, chatRoomService);

    }

    private <T> void sendMessage(T message, ChatRoomService chatRoomService) {
        sessions.parallelStream()
                .forEach(session -> chatRoomService.sendMessage(session, message));
    }
}
