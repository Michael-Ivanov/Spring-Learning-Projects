package com.example.rabbitmqhelloworld.rest;

import com.example.rabbitmqhelloworld.messaging.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessagingRestController {

    private Sender sender;

    @Autowired
    public MessagingRestController(Sender sender) {
        this.sender = sender;
    }

    @GetMapping("/send")
    public void sendMessage(@RequestParam("message") String message) {
        sender.sendMessage(message);
    }
}
