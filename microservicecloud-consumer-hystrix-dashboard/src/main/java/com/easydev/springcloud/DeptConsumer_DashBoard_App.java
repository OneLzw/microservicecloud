package com.easydev.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@EnableHystrixDashboard
@SpringBootApplication
public class DeptConsumer_DashBoard_App {

    private static Logger logger = LoggerFactory.getLogger(DeptConsumer_DashBoard_App.class);

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_DashBoard_App.class , args);
        logger.info("DeptConsumer_DashBoard_App start success!");
    }
}
