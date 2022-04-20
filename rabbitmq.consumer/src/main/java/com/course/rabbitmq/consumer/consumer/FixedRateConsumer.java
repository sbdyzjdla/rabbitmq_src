package com.course.rabbitmq.consumer.consumer;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class FixedRateConsumer {

    private Logger LOG = LoggerFactory.getLogger(FixedRateConsumer.class);

    @RabbitListener(queues = "course.fixedrate")
    public void listen(String message) {
        LOG.info("Consuming {}", message);
    }

}
