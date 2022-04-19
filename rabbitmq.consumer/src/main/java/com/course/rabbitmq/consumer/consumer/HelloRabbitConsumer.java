package com.course.rabbitmq.consumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloRabbitConsumer {

    /**
     * 대기열에서 메시지를 소비
     */
    @RabbitListener(queues = "course.hello")
    public void listen(String message) {
        System.out.println("Consuming " + message);
    }
}
