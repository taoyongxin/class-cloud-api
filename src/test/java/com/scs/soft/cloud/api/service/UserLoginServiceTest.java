package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.dto.QueryDto;
import com.scs.soft.cloud.api.domain.entity.UserLogin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest(classes = CloudApiApplication.class)
class UserLoginServiceTest {
    @Resource
    private UserLoginService userLoginService;

    @Test
    void updatePassword() {
        UserLogin userLogin = UserLogin.builder()
                .mobile("17826012312")
                .password("999")
                .build();
        userLoginService.updateUserPassword(userLogin);
    }

    @Test
    void findUserBy() {
        QueryDto queryDto = QueryDto.builder()
                .equalsString("17826012399")
                .build();
        /*userLoginService.findUserBy(queryDto);*/
        System.out.println(userLoginService.findUserBy(queryDto));
    }
}