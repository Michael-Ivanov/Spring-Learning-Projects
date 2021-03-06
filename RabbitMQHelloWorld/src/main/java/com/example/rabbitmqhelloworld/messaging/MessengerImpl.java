package com.example.rabbitmqhelloworld.messaging;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.stereotype.Component;

@Component
public class MessengerImpl implements Messenger {

    private final static String QUEUE_NAME = "hello";

    @Override
    public void sendMessage(String message) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" Sent '" + message + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String receiveMessage() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" Waiting for messages. To exit press CTRL+C");
            DeliverCallback deliverCallback = (s, delivery) -> {
                String message = new String(delivery.getBody());
                System.out.println(" Received '" + message + "'");
            };

            return channel.basicConsume(QUEUE_NAME, true, deliverCallback, s -> {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "No message. Something wrong.";
    }
}
