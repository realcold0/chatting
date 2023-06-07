package com.capstone.chatting.Controller;

import com.capstone.chatting.DTO.MatchingMember;
import com.capstone.chatting.DTO.MatchingMessage;
import com.capstone.chatting.Service.MatchingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

@Controller
@Component
@RequiredArgsConstructor
@Log4j2
public class MatchingController {

    private final RabbitTemplate template;
//    private final static String MATCH_EXCHANGE_NAME = "matching,exchange";
    private final static String MATCH_QUEUE_NAME = "matching.queue";

    private final MatchingService matchingService;

//    //matching queue에서 매칭 된 그룹 받기
    @RabbitListener(queues = MATCH_QUEUE_NAME)
    public void receiveMatching(MatchingMessage messages) {
        matchingService.processMatch(messages);
    }
}
