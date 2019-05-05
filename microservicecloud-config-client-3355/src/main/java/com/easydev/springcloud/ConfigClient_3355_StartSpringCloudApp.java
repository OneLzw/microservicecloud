package com.easydev.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClient_3355_StartSpringCloudApp {

    private static Logger logger = LoggerFactory.getLogger(ConfigClient_3355_StartSpringCloudApp.class);

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient_3355_StartSpringCloudApp.class,args);
        logger.info("ConfigClient_3355_StartSpringCloudApp Start Success!");
    }

}
