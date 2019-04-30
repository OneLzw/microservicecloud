package com.easydev.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Config_3344_StartSpringCloudApp {

    private static Logger logger = LoggerFactory.getLogger(Config_3344_StartSpringCloudApp.class);

    public static void main(String[] args) {
        SpringApplication.run(Config_3344_StartSpringCloudApp.class , args);
        logger.info("Config_3344_StartSpringCloudApp Start Success!");
    }
}
