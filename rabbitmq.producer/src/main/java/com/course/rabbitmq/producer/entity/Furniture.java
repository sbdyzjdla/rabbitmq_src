package com.course.rabbitmq.producer.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Furniture {

    private String color;
    private String material;
    private String name;
    private int price;

    @Override
    public String toString() {
        return "Furniture{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
