package com.capstone.chatting.Service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {
    private final RabbitTemplate rabbitTemplate;

    public MessageSenderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Message message) {
        System.out.println("message Send!!");
        rabbitTemplate.convertAndSend("topic.exchange", "sample.realcold.#", message);
    }
}