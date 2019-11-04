package com.example.demoeurekaserver2copy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoEurekaServer2CopyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaServer2CopyApplication.class, args);
    }

}
