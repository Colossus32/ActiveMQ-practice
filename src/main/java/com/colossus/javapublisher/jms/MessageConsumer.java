package com.colossus.javapublisher.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @JmsListener(destination = "demo")
    public void receiveMessage(String messageStr){
        System.out.println(messageStr);
        //need some class to construct an instance by ObjectMapper
    }
}
