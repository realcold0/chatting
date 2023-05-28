package com.capstone.chatting.Service;

import com.capstone.chatting.ChatWebSocketHandler;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Service
@Slf4j
public class MessageListenerService {

    @Autowired
    private ChatWebSocketHandler chatWebSocketHandler;

    @RabbitListener(queues = "sample.queue")
    public void handleMessage(String message) {
        // RabbitMQ로부터 수신한 메시지 처리


        System.out.println("receive from queue: " + message);

        for (WebSocketSession session : chatWebSocketHandler.getSessions().values()) {
            try {
                session.sendMessage(new TextMessage(message)); //클라이언트로 보내짐

            } catch (Exception e) {
                log.error("Failed to send message to WebSocket client", e);
            }
        }
        System.out.println(chatWebSocketHandler.getSessions());
    }
}