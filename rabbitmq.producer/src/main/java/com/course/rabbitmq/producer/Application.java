package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.producer.HelloRabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application implements CommandLineRunner {

	/**
	 * CommandLineRunner - 스프링부트가 구동되자마자 특정코드를 실행시키고 싶을때
	 */
//	@Autowired
//	private HelloRabbitProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		producer.sendHello("yoonsung " + Math.random());
	}


}
