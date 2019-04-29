package com.easydev.springcloud.service;

import com.easydev.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-DEPT")
@RequestMapping("/dept")
@Component
public interface DeptClientService {

    @PostMapping("/add")
    public boolean add(Dept dept);

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") long id);

    @GetMapping("/list")
    public List<Dept> list();

    @GetMapping("/discovery")
    public Object discovery();
}
