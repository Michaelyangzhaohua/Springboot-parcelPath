package com.michaelyzh.parcel_path.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.SMS")
public class SMSReceiver {
    @RabbitHandler
    public void process(String message) {
        System.out.println("SMS service: " + message);
    }
}
