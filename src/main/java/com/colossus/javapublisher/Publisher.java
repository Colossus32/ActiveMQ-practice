package com.colossus.javapublisher;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Publisher {

    public static void main(String[] args) {
        SpringApplication.run(Publisher.class, args);
        ConnectionFactory factory = new ActiveMQConnectionFactory("admin","admin", "tcp://localhost:61616");
        try {
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("demo");

            //TextMessage textMessage = session.createTextMessage("First message!");
            MessageProducer producer = session.createProducer(destination);

            for (int i = 0; i < 50; i++) {
                String dummy = String.format("Message from producer - #%d",i);
                producer.send(session.createTextMessage(dummy));
            }

            System.out.println("Message published");
            session.close();
            connection.close();

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

}
