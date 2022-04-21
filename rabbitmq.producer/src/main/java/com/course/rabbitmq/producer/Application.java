package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.course.rabbitmq.producer.producer.EmployeeJsonProducer;
import com.course.rabbitmq.producer.producer.HelloRabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

@SpringBootApplication
//@EnableScheduling
public class Application implements CommandLineRunner {

	/**
	 * CommandLineRunner - 스프링부트가 구동되자마자 특정코드를 실행시키고 싶을때
	 */
//	@Autowired
//	private HelloRabbitProducer producer;

	@Autowired
	private EmployeeJsonProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=0; i<5; ++i) {
			var employee = new Employee("emp" + i, "Employee" +i, LocalDate.now());
			producer.sendMessage(employee);
		}
	}
}
