package com.easydev.springcloud;

import com.easydev.myrule.RibbonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//在启动微服务的时候就能去加载我们自定义的Ribbon配置类，从而使配置生效
@RibbonClient(name = "MICROSERVICECLOUD-DEPT" , configuration = RibbonConfig.class)
public class DeptConsumer80_App {

    private static Logger logger = LoggerFactory.getLogger(DeptConsumer80_App.class);

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class , args);
        logger.info("DeptConsumer80_App Start Success!");
    }
}
