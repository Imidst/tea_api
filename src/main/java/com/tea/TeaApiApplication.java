package com.tea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wenlong
 */
@SpringBootApplication
@MapperScan(basePackages = "com.tea.mapper")
public class TeaApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeaApiApplication.class, args);
    }
}
