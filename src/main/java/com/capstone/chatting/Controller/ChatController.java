package com.capstone.chatting.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/message")
    public String sendMessage(String message){
        String processedMessage = "서버에서 보낸 메시지: " + message;
        return processedMessage;
    }
}
