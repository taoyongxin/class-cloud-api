package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.entity.UserClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest(classes = CloudApiApplication.class)
class UserClassServiceTest {

    @Resource
    private UserClassService userClassService;
    @Test
    void insertUserClass() {
        UserClass userClass = UserClass.builder()
                .userId(10)
                .roleId(1)
                .classId(3)
                .experience(0)
                .build();
        userClassService.insertUserClass(userClass);
    }
}