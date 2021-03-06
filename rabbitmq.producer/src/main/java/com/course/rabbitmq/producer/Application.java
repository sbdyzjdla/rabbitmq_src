package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.course.rabbitmq.producer.entity.Furniture;
import com.course.rabbitmq.producer.entity.Picture;
import com.course.rabbitmq.producer.producer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
//@EnableScheduling
public class Application implements CommandLineRunner {

	/**
	 * CommandLineRunner - 스프링부트가 구동되자마자 특정코드를 실행시키고 싶을때
	 */
//	@Autowired
//	private HelloRabbitProducer producer;

//	@Autowired
//	private EmployeeJsonProducer producer;

//	@Autowired
//	private HumanResourceProducer producer;

//	@Override
//	public void run(String... args) throws Exception {
//		for(int i=0; i<5; ++i) {
//			var employee = new Employee("emp" + i, "Employee" +i, LocalDate.now());
//			producer.sendMessage(employee);
//		}
//	}

//	@Autowired
//	private PictureProducer producer;

	@Autowired
	private MyPictureProducer producer;

	// valid source
	private final List<String> SOURCES = List.of("mobile", "web");

	// valid types
	private final List<String> TYPES = List.of("jpg", "png", "svg");

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=0; i<1; ++i) {
			var picture = new Picture();
			picture.setName("Picture " + i);
			picture.setSize(ThreadLocalRandom.current().nextLong(9000, 10000));
			picture.setSource(SOURCES.get(i % SOURCES.size()));
			picture.setType(TYPES.get(i % TYPES.size()));

			producer.sendMessage(picture);
		}
	}

	/*
	@Autowired
	private FurnitureProducer producer;

	private final List<String> COLORS = List.of("write", "red", "green");

	private final List<String> MATERIALS = List.of("wood", "plastic", "steel");


	@Override
	public void run(String... args) throws Exception {
		for(int i=0; i<10; ++i) {
			Furniture furniture = new Furniture();
			furniture.setName("Furniture " + i);
			furniture.setColor(COLORS.get(i % COLORS.size()));
			furniture.setMaterial(MATERIALS.get(i % MATERIALS.size()));
			furniture.setPrice(i);

			producer.sendMessage(furniture);
		}
	}
	*/
}
