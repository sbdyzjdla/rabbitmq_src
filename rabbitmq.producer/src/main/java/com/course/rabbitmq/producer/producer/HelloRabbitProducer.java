package com.course.rabbitmq.producer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class HelloRabbitProducer {

    @Autowired
    // RabbitMQ에 publish하는 클래스 인스턴스 생성
    private RabbitTemplate rabbitTemplate;

    /**
     * RabbitMQ에 메세지를 보내는 메소드
     * RabbitMQ에 보내는 모든 메세지는 바이트 배열형태로 보내야함
     * Spring에서는 rabbitTemplate.convertAndSend를 사용하여 작업을 수행 (rabbitTemplate가 바이트 배열로 변환)
     * exchange를 매개변수로 사용하지 않
     * @param name
     */
    public void sendHello(String name) {
        rabbitTemplate.convertAndSend("course.hello", "hello " + name);
    }
}
