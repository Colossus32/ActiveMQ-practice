package com.colossus.javapublisher;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.JSONObject;

public class RealTimeExemple {
    public static void main(String[] args) {
        ConnectionFactory factory = new ActiveMQConnectionFactory("admin","admin", "tcp://localhost:61616");
        try {
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("demo");

            JSONObject json = new JSONObject();
            json.put("from date", "11.08.2023");
            json.put("to date", "06.12.2023");
            json.put("email", "tr@ya.ru");
            json.put("query", "select * from data");

            TextMessage textMessage = session.createTextMessage(json.toString());

            MessageProducer producer = session.createProducer(destination);
            producer.send(textMessage);

            session.close();
            connection.close();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
