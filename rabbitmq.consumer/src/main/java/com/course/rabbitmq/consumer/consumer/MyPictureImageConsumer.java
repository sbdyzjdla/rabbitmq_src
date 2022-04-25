package com.course.rabbitmq.consumer.consumer;

import com.course.rabbitmq.consumer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MyPictureImageConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(MyPictureImageConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "q.mypicture.image")
    public void listen(String message) throws IOException {
        var picture = objectMapper.readValue(message, Picture.class);

        if(picture.getSize() > 9000 ) {
            throw new IllegalArgumentException("picture size too large : " + picture);
        }

        LOG.info("On image : {}", picture);
    }

}
