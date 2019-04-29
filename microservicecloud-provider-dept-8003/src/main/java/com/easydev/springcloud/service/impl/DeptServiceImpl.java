package com.easydev.springcloud.service.impl;

import com.easydev.springcloud.dao.DeptDao;
import com.easydev.springcloud.entity.Dept;
import com.easydev.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    public Dept get(long id) {
        return deptDao.findById(id);
    }

    public List<Dept> list() {
        return deptDao.findAll();
    }
}
