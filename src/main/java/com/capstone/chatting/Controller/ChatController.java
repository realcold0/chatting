package com.capstone.chatting.Controller;

import com.capstone.chatting.ChatWebSocketHandler;
import com.capstone.chatting.DTO.ChatMessage;
import com.capstone.chatting.Service.MessageSenderService;
import com.capstone.chatting.repository.ChatRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@Log4j2
public class ChatController {


    private final Map<String, WebSocketSession> sessions;
    private final static String CHAT_EXCHANGE_NAME = "amq.topic";
    private final static String CHAT_QUEUE_NAME = "sample.queue";

    private final MessageSenderService messageSenderService;

    @MessageMapping("chat.enter.{chatRoomId}")
    public void sendMessage(@Payload ChatMessage chatMessage, @DestinationVariable String chatRoomId){

         messageSenderService.recordMessage(chatRoomId,chatMessage);
    }


    @MessageMapping("sendMessage")
    @SendTo("/topic/default")
    public String send(String str)
    {
        return str;
    }

//    @RabbitListener(queues = CHAT_QUEUE_NAME)
//    public void handleMessage(String message) {
//        // RabbitMQ로부터 수신한 메시지 처리
//        System.out.println("receive from queue: " + message);
//
//        for (WebSocketSession session : sessions.values()) {
//            try {
//
//                session.sendMessage(new TextMessage(message)); //클라이언트로 보내짐
//
//                System.out.println("To send : "+ session);
//            } catch (Exception e) {
//                log.error("Failed to send message to WebSocket client", e);
//            }
//        }
//    }
}
