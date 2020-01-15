package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.SignDto;
import com.scs.soft.cloud.api.service.UserDevService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = CloudApiApplication.class)
class UserDevServiceImplTest {
    @Resource
    private UserDevService userDevService;

    @Test
    void login() {
        SignDto signDto = SignDto.builder().mobile("17826012341").password("111").build();
        Result result = userDevService.login(signDto);
        System.out.println(result);
    }
}