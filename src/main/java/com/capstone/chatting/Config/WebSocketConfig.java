package com.capstone.chatting.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry)
    {
        registry.setPathMatcher(new AntPathMatcher("."));
        registry.setApplicationDestinationPrefixes("/app")
                .enableStompBrokerRelay("/topic", "/exchange", "/queue")
                .setRelayHost("13.209.204.63")
                .setRelayPort(61613)
                .setVirtualHost("/")
                .setClientLogin("guest")
                .setClientPasscode("guest");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").setAllowedOrigins("*");
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registry)
    {
        registry.interceptors(new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor =
                        MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

                if (accessor != null && accessor.getCommand() != null) {
                    if ("CONNECT".equals(accessor.getCommand().getMessageType().toString())) {
                        // 클라이언트가 CONNECT 메시지를 보낼 때 세션을 저장합니다.
                        // 예를 들어, 세션을 어딘가에 맵으로 저장하거나 필요에 따라 다른 작업을 수행할 수 있습니다.
                        String sessionId = accessor.getSessionId();
                        System.out.println("user  session : "+ sessionId);




                        // 세션을 저장하는 작업을 수행하세요.
                    }
                }

                return message;
            }
        });
    }





}
