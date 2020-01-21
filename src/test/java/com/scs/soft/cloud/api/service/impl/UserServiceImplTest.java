package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.dto.RegisterDto;
import com.scs.soft.cloud.api.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest(classes = CloudApiApplication.class)
class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    void insertUser() {
        RegisterDto registerDto = RegisterDto.builder()
                .mobile("17826012355")
                .profession("学生")
                .name("tyx")
                .jobNumber("1802222")
                .build();
        userService.insertUser(registerDto);

    }
}