package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.common.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = CloudApiApplication.class)
class ClassServiceTest {
    @Resource
    private ClassService classService;
    @Test
    void getClassById() {
        Result result = classService.getClassById(1);
        System.out.println(result);
    }
}