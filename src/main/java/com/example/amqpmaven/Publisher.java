package com.example.amqpmaven;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Publisher {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;

    @Value("${jsa.rabbitmq.routingkey}")
    private String routingKey;

    // Creates the message and using the routing key + exhcnage defined, the message will be sent and if queued if multiple messages follow
    public void produceMsg(String msg){
        amqpTemplate.convertAndSend(exchange, routingKey, msg);
        System.out.println("<--------------------Publisher--------------------->");
        System.out.println("Publisher Produced Message: " + msg);
    }
}