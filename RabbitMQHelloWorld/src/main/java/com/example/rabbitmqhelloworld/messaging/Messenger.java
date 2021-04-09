package com.example.rabbitmqhelloworld.messaging;

public interface Messenger {

    void sendMessage(String message);

    String receiveMessage();

}
