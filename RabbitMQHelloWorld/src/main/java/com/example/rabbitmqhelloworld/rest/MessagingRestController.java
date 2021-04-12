package com.example.rabbitmqhelloworld.rest;

import com.example.rabbitmqhelloworld.messaging.Messenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessagingRestController {

    private Messenger messenger;

    @Autowired
    public MessagingRestController(@Qualifier("rabbitTemplateMessengerImpl") Messenger messenger) {
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
