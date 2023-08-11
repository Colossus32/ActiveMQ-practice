package com.colossus.javapublisher;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {
    public static void main(String[] args) {
        ConnectionFactory factory = new ActiveMQConnectionFactory("admin","admin", "tcp://localhost:61616");

        try(Connection connection = factory.createConnection()) {
            connection.start();
            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            Destination destination = session.createQueue("demo");
            MessageConsumer consumer = session.createConsumer(destination);

            consumer.setMessageListener(message -> {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("Consumer got a message: " + textMessage.getText());

                } catch (JMSException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
