package com.colossus.javapublisher.jms;

import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessagePublisher {

    private JmsTemplate jmsTemplate;
    public void sendMessage(String queue, final String messageStr){
        jmsTemplate.send(queue, session -> session.createObjectMessage(messageStr));
    }
}
