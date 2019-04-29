package com.easydev.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //表明服务发现
public class DeptProvider8003_App {

    private static Logger logger = LoggerFactory.getLogger(DeptProvider8003_App.class);

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8003_App.class , args);
        logger.info("DeptProvider8003_App Start Success!");
    }
}
