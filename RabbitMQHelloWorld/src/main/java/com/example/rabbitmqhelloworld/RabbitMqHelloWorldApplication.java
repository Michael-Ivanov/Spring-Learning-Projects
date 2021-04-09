package com.example.rabbitmqhelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqHelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqHelloWorldApplication.class, args);
        Sender sender = new Sender();
        sender.sendMessage();
    }

}