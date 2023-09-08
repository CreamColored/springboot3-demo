package com.amadeus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.amadeus.mapper")
public class Springboot3DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot3DemoApplication.class, args);
    }

}
