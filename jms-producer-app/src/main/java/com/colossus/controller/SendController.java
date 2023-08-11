package com.colossus.controller;

import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class SendController {

    private JmsTemplate jmsTemplate;
    @GetMapping("send/{message}")
    public String send(@PathVariable("message") String message){
        jmsTemplate.send("demo", session -> session.createObjectMessage(message));
        return message;
    }
}

