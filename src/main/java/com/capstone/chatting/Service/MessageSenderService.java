package com.capstone.chatting.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageSenderService {
    private final RabbitTemplate rabbitTemplate;



    public void sendMessage(String message) {
        System.out.println("message Send!! by Rabbit");
        rabbitTemplate.convertAndSend("topic.exchange", "sample.realcold.#", message);
    }
}