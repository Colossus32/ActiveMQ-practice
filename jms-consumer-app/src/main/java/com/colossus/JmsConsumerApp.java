package com.colossus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JmsConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(JmsConsumerApp.class, args);
    }
}