package com.colossus.javapublisher;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicConsumer {
    public static void main(String[] args) {
        ConnectionFactory factory = new ActiveMQConnectionFactory("admin","admin", "tcp://localhost:61616");
        System.out.println("start consume...");

        try {
            Connection connection = factory.createConnection();
            connection.setClientID("1");
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Topic topic = session.createTopic("Demo-Topic");

            MessageConsumer consumer = session.createDurableSubscriber(topic, "TopicConsumer-1");
            consumer.setMessageListener(message -> {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            });
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
