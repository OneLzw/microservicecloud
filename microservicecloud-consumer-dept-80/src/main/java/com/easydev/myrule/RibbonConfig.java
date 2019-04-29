package com.easydev.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Ribbon自定义配置类，不能放在@CommengScan所在的包及其子包下，故需要重新创建包，重新配置
@Configuration
public class RibbonConfig{

    @Bean
    public IRule myRule () {
        return new RandomRule_Easy();
    }
}
