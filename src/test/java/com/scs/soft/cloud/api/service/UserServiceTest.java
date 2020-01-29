package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.dto.RegisterDto;
import com.scs.soft.cloud.api.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = CloudApiApplication.class)
class UserServiceTest {
    @Resource
    private UserService userService;
    @Test
    void updateUser() {
        User user = User.builder().mobile("17826012341")
                .nickname("TYXTYXTYX")
                .build();
        userService.updateUser(user);
    }

    @Test
    void findUserByMobile() {
        RegisterDto registerDto = RegisterDto.builder()
                .mobile("17826012341")
                .build();
        System.out.println(userService.findUserByMobile(registerDto));
    }
}