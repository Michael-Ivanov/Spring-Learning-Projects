package com.example.rabbitmqhelloworld.rest;

import com.example.rabbitmqhelloworld.messaging.Receiver;
import com.example.rabbitmqhelloworld.messaging.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessagingRestController {

    private Sender sender;
    private Receiver receiver;

    @Autowired
    public MessagingRestController(Sender sender, Receiver receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    @GetMapping("/send")
    public void sendMessage(@RequestParam("message") String message) {
        sender.sendMessage(message);
    }

    @GetMapping("/receive")
    public String receiveMessage() {
        return receiver.receiveMessage();
    }
}
