package com.wind.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"com.wind"},
        exclude = {DataSourceAutoConfiguration.class})
@PropertySource({"classpath:conf/env/datasource.properties", "classpath:conf/env/config.properties"})
public class WebApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.location", "classpath:conf/env/spring-boot.properties");
        SpringApplication.run(WebApplication.class, args);
    }
}
