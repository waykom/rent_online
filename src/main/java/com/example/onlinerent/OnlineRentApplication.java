package com.example.onlinerent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.onlinerent.mapper")
public class OnlineRentApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineRentApplication.class, args);
    }

}
