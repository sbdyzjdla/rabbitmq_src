package com.course.rabbitmq.producer.producer;

import com.course.rabbitmq.producer.entity.Furniture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class FurnitureProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * messageProperties 객체 생성후 Header 세팅
     * 객체 json으로 변경
     * message객체를 json의 바이트 형식과 메세지 프로퍼티로 생성
     * rabbitTemplate로 메세지 보냄
     * @param furniture
     * @throws IOException
     */
    public void sendMessage(Furniture furniture) throws IOException {
        var messageProperties = new MessageProperties();
        messageProperties.setHeader("color", furniture.getColor());
        messageProperties.setHeader("material", furniture.getMaterial());

        var json = objectMapper.writeValueAsString(furniture);

        var message = new Message(json.getBytes(), messageProperties);

        rabbitTemplate.convertAndSend("x.promotion", "", message);
    }
}
