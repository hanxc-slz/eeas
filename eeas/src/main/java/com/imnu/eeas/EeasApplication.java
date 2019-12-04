package com.imnu.eeas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.imnu.eeas.dao")
public class EeasApplication {

    public static void main(String[] args) {
        SpringApplication.run(EeasApplication.class, args);
    }

}
