package com.capstone.chatting.Service;

import com.capstone.chatting.DTO.ChatMessage;
import com.capstone.chatting.DTO.ChatRecordDto;
import com.capstone.chatting.domain.ChatRecord;
import com.capstone.chatting.domain.RoomType;
import com.capstone.chatting.repository.ChatRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageSenderService {

    private final RabbitTemplate rabbitTemplate;
    ChatRecordRepository chatRecordRepository;

    public void sendMessage(String message) {
        System.out.println("message Send!! by Rabbit");
        rabbitTemplate.convertAndSend("topic.exchange", "sample.realcold.#", message);
    }

    public void recordMessage(ChatRecordDto message){
        chatRecordRepository.save(message.createChatRecord());
    }


}