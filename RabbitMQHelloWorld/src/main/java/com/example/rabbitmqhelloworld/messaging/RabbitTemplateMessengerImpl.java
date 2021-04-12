package com.example.rabbitmqhelloworld.messaging;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitTemplateMessengerImpl implements Messenger {

    private RabbitTemplate rabbitTemplate;
    private MessageConverter converter;

    @Autowired
    public RabbitTemplateMessengerImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        converter = rabbitTemplate.getMessageConverter();
    }

    @Override
    public void sendMessage(String lineToSend) {
        MessageProperties properties = new MessageProperties();
        Message message = converter.toMessage(lineToSend, properties);
        rabbitTemplate.send("hello world queue", message);
    }

    @Override
    public String receiveMessage() {
        Message message = rabbitTemplate.receive("hello world queue");
        String receivedLine = (String) converter.fromMessage(message);
        return receivedLine;
    }
}
