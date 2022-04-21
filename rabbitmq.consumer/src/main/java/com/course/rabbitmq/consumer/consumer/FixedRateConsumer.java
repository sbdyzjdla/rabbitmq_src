package com.course.rabbitmq.consumer.consumer;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

//@Service
public class FixedRateConsumer {

    private Logger LOG = LoggerFactory.getLogger(FixedRateConsumer.class);

    // concurrency = "3-7"  =  최소 3개에서 7개 까지의 동시성생성을 스프링이 관
    @RabbitListener(queues = "course.fixedrate", concurrency = "3-7")
    public void listen(String message) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(1000, 2000));
        LOG.info("{} : Consuming {}", Thread.currentThread().getName() ,message);
    }

}
