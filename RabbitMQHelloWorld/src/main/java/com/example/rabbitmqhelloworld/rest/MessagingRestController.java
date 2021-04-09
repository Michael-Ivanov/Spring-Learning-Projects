package com.example.rabbitmqhelloworld.rest;

import com.example.rabbitmqhelloworld.messaging.MessengerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessagingRestController {

    private MessengerImpl messenger;

    @Autowired
    public MessagingRestController(MessengerImpl messenger) {
        this.messenger = messenger;
    }

    @GetMapping("/send")
    public void sendMessage(@RequestParam("message") String message) {
        messenger.sendMessage(message);
    }

    @GetMapping("/receive")
    public String receiveMessage() {
        return messenger.receiveMessage();
    }
}
