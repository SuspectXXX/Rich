package com.rich.rich;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@MapperScan(value = "com.rich.rich.mapper")
@SpringBootApplication
//@EnableConfigurationProperties
public class RichApplication {

    public static void main(String[] args) {
        SpringApplication.run(RichApplication.class, args);
    }

}
