package com.example.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@ServletComponentScan // Servlet Auto-Registration
public class ServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletApplication.class, args);
    }


    /*
    * Spring Boot가 application.properties 있는 설정정보를 가져와 아래와같이 Bean으로 등록해준다.
    * 아래처럼 직접 빈으로 등록해도 문제없고, 우선순위도 더 높다.
    * */
    @Bean
    InternalResourceViewResolver internalResourceViewResolver() {
        return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
    }

}
