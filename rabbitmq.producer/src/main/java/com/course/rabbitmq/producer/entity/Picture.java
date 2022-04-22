package com.course.rabbitmq.producer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Picture {

    private String name;
    private String type;
    private String source;
    private long size;

    @Override
    public String toString() {
        return "Picture{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", source='" + source + '\'' +
                ", size=" + size +
                '}';
    }
}
