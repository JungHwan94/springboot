package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.study.springboot") // 정확한 패키지 경로 설정
public class SemiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SemiApplication.class, args);
    }
}
