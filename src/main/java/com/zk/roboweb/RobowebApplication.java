package com.zk.roboweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.zk.roboweb.dao")
public class RobowebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobowebApplication.class, args);
    }

}
