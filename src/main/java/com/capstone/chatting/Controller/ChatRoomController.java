package com.capstone.chatting.Controller;

import com.capstone.chatting.DTO.ChatRoom;
import com.capstone.chatting.Service.ChatRoomService;
import com.rabbitmq.client.AMQP;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;


    @GetMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam("name") String name){
        ChatRoom chatRoom = chatRoomService.createRoom(name);
        System.out.println(name + "room is created!!");

        String queueName = "room." + name;



        return chatRoom;
    }


}
