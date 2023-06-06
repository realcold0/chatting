package com.capstone.chatting.Service;

import com.capstone.chatting.DTO.ChatMessage;
import com.capstone.chatting.DTO.ChatRecordDto;
import com.capstone.chatting.domain.ChatRecord;
import com.capstone.chatting.domain.RoomType;
import com.capstone.chatting.repository.ChatRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageSenderService {

    private final RabbitTemplate template;

    private final ChatRecordRepository chatRecordRepository;

    private final static String CHAT_EXCHANGE_NAME = "amq.topic";


    public void recordMessage(String chatRoomId ,ChatMessage message){
        System.out.println("send message : " + message);
        template.convertAndSend(CHAT_EXCHANGE_NAME, "room." + chatRoomId, message);
        chatRecordRepository.save(message.createChatMessage());
    }


}