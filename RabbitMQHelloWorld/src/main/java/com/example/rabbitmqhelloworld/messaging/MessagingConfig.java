package com.example.rabbitmqhelloworld.messaging;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    @Bean
    public Queue queue() {
        return new Queue("hello world queue");
    }
}
