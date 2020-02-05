package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.dto.PageDto;
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

    @Test
    void selectUserClassByClassId() {
        System.out.println(userClassService.selectUserClassByClassId(1));
    }

    @Test
    void selectUserMessageByClassId() {
        PageDto pageDto = PageDto.builder()
                .field(1)
                .currentPage(3)
                .pageSize(2)
                .build();
        System.out.println(userClassService.selectUserMessageByClassId(pageDto));

    }
}