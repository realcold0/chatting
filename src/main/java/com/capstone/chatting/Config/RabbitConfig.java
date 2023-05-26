package com.capstone.chatting.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitConfig {
    @Bean
    public Queue chatQueue() {
        return new Queue("sample.queue");
    }

    @Bean
    public TopicExchange chatExchange() {
        return new TopicExchange("topic.exchange");
    }

    @Bean
    public Binding chatBinding(Queue chatQueue, TopicExchange chatExchange) {
        return BindingBuilder.bind(chatQueue).to(chatExchange).with("sample.realcold.#");
    }
}
