package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.SignDto;
import com.scs.soft.cloud.api.service.UserLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = CloudApiApplication.class)
class UserLoginServiceImplTest {

    @Resource
    private UserLoginService userLoginService;
    @Test
    void register() {
        SignDto signDto = SignDto.builder()
                .mobile("17826012341")
                .password("111")
                .sms("111")
                .build();
        Result result = userLoginService.register(signDto);
        System.out.println(result);
    }
}