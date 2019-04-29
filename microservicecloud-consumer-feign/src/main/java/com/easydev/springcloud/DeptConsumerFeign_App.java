package com.easydev.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.easydev.springcloud"})
@ComponentScan("com.easydev.springcloud")
public class DeptConsumerFeign_App {

    private static Logger logger = LoggerFactory.getLogger(DeptConsumerFeign_App.class);

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign_App.class , args);
        logger.info("DeptConsumerFeign_App Start Success!");
    }
}
