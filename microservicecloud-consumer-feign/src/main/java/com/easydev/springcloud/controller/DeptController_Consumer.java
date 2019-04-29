package com.easydev.springcloud.controller;

import com.easydev.springcloud.entity.Dept;
import com.easydev.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/consumer")
@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService deptClientService;

    @PostMapping("/dept/add")
    public boolean add(Dept dept) {
        return deptClientService.add(dept);
    }

    @GetMapping("dept/get/{id}")
    public Dept get (@PathVariable("id") long id) {
        return deptClientService.get(id);
    }

    @GetMapping("dept/list")
    public List<Dept> list () {
        return deptClientService.list();
    }

    @GetMapping("/dept/discovery")
    public Object discovery () {
        return deptClientService.discovery();
    }
}
