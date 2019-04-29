package com.easydev.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //表明服务发现
@EnableCircuitBreaker //表明熔断器可用
public class DeptProviderHystrix8001_App {

    private static Logger logger = LoggerFactory.getLogger(DeptProviderHystrix8001_App.class);

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix8001_App.class , args);
        logger.info("DeptProviderHystrix8001_App Start Success!");
    }
}
