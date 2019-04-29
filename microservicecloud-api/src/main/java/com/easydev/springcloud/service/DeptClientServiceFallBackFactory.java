package com.easydev.springcloud.service;

import com.easydev.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public boolean add(Dept dept) {
                return false;
            }

            public Dept get(long id) {
                return new Dept().setDeptNo(id).setDname("查询不到对应信息，Consumer客户端提供的降级消息，此刻该provider已关闭")
                        .setDb_source("no db_source");
            }

            public List<Dept> list() {
                return null;
            }

            public Object discovery() {
                return null;
            }
        };
    }
}
