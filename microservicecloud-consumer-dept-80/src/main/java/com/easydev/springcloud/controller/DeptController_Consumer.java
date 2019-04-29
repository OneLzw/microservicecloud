package com.easydev.springcloud.controller;

import com.easydev.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/consumer")
@RestController
public class DeptController_Consumer {

//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add" , dept , Boolean.class);
    }

    @GetMapping("dept/get/{id}")
    public Dept get (@PathVariable("id") long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id , Dept.class);
    }

    @GetMapping("dept/list")
    public List<Dept> list () {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list"  , List.class);
    }

    @GetMapping("/dept/discovery")
    public Object discovery () {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery" , Object.class);
    }
}
