package com.capstone.chatting.Service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListenerService {
    @RabbitListener(queues = "sample.queue")
    public void handleMessage(String message) {
        // RabbitMQ로부터 수신한 메시지 처리
        System.out.println("수신한 메시지: " + message);
    }
}