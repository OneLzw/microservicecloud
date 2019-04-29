package com.easydev.springcloud.controller;

import com.easydev.springcloud.entity.Dept;
import com.easydev.springcloud.service.DeptService;
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

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") long id) {
        return deptService.get(id);
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
