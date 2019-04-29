package com.easydev.springcloud.controller;

import com.easydev.springcloud.entity.Dept;
import com.easydev.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dept")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/add")
    public boolean add(Dept dept) {
        return deptService.add(dept);
    }

    //一旦调用服务方式失败并抛出错误信息后，会自动调用@HystrixCommand所标注的fallbackMethod中说声明的方法
    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "getFallBackMethod")
    public Dept get(@PathVariable("id") long id) {
        Dept dept = deptService.get(id);
        if (dept == null) {
            throw new RuntimeException("this is a error");
        }
        return deptService.get(id);
    }

    public Dept getFallBackMethod (@PathVariable("id") long id) {
        return new Dept().setDeptNo(id).setDb_source("no Db_source").setDname("没有数据");
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return deptService.list();
    }

    @GetMapping("/discovery")
    public Object discovery () {
        List<String> list = discoveryClient.getServices();
        System.out.println("************:" + list.size());
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance serviceInstance :instances) {
            System.out.println(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }
        return this.discoveryClient;
    }
}
