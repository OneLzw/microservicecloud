package com.easydev.springcloud.dao;

import com.easydev.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(long id);

    public List<Dept> findAll();
}
