package com.capstone.chatting.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry)
    {
        //registry.enableSimpleBroker( "/topic");
        registry.setPathMatcher(new AntPathMatcher("."));
        registry.setApplicationDestinationPrefixes("/app")
                .enableStompBrokerRelay("/topic")
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

}
