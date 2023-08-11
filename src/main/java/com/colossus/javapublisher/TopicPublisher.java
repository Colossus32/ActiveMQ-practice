package com.colossus.javapublisher;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TopicPublisher {

    public static void main(String[] args) {
        SpringApplication.run(TopicPublisher.class, args);
        ConnectionFactory factory = new ActiveMQConnectionFactory("admin","admin", "tcp://localhost:61616");
        try {
            Connection connection = factory.createConnection();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createTopic("Demo-Topic");

            MessageProducer producer = session.createProducer(destination);

            TextMessage textMessage = session.createTextMessage("Message For Topic really important +++");

            producer.send(textMessage);

            System.out.println("Message published to topic");

            session.close();
            connection.close();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

}
