package com.example.demoalibabanacosconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoAlibabaNacosConfigApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(DemoAlibabaNacosConfigApplication.class, args);
        System.out.println(context.getEnvironment().getProperty("user.name"));
        System.out.println(context.getEnvironment().getProperty("user.age"));
    }

    @RestController
    @RefreshScope
    class HelloController{
        @Value("${user.name}")
        private String name;
        @Value("${user.age}")
        private Integer age;
        @GetMapping
        public String user(){
            return name+":"+age;
        }
    }

}
