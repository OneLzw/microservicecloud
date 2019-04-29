package com.easydev.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //ribbon是基于客户端的负载均衡工具
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
