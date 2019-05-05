package com.easydev.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//表示该服务是eureka服务端的标签
@EnableEurekaServer
public class Config_Git_EurekaServerApplication {

    private static Logger logger = LoggerFactory.getLogger(Config_Git_EurekaServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Config_Git_EurekaServerApplication.class , args);
        logger.info("Config_Git_EurekaServerApplication Start Success!");
    }
}
