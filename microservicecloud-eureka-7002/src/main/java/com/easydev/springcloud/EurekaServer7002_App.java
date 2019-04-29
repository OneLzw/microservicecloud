package com.easydev.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//表示该服务是eureka服务端的标签
@EnableEurekaServer
public class EurekaServer7002_App {

    private static Logger logger = LoggerFactory.getLogger(EurekaServer7002_App.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002_App.class , args);
        logger.info("EurekaServer7001_App Start Success!");
    }
}
