package com.course.rabbitmq.producer.producer;

import com.course.rabbitmq.producer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class PictureProducerTwo {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(Picture picture) throws IOException {
        var json = objectMapper.writeValueAsString(picture);
        var sb = new StringBuilder();

        // 1st picture source
        sb.append(picture.getSource());
        sb.append(".");

        // 2nd picture size
        if(picture.getSize() > 4000) {
            sb.append("large");
        } else {
            sb.append("small");
        }
        sb.append(".");

        // 3rd picture type
        sb.append(picture.getType());

        rabbitTemplate.convertAndSend("x.picture2", sb.toString(), json);
    }
}
