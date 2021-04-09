package com.example.rabbitmqhelloworld;

import com.example.rabbitmqhelloworld.messaging.Sender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqHelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqHelloWorldApplication.class, args);
    }

}
