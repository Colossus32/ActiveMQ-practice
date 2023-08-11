package com.colossus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JmsProducerApp {
    public static void main(String[] args) {
        SpringApplication.run(JmsProducerApp.class, args);
    }
}