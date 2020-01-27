package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.Class;
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

    @Test
    void getClassByCreatorId() {
        Result result = classService.getClassByCreatorId(1);
        System.out.println(result);
    }

    @Test
    void getClassByInvitationCode() {
        Result result = classService.getClassByInvitationCode(411001);
        System.out.println(result);
    }

    @Test
    void insertClass() {
        Class class1 = Class.builder()
                .creatorId(13211111)
                .classType("11551")
                .thumbnail("111.jpg")
                .name("111111")
                .semester("11111")
                .build();
        Result result = classService.insertClass(class1);
        System.out.println(result);
    }

    @Test
    void testGetClassById() {
        Result result = classService.getClassById(1);
        System.out.println(result);
    }

    @Test
    void updateClass() {
        Class class1 = Class.builder()
                .id(2)
                .classType("测试classType")
                .thumbnail("111")
                .name("111")
                .semester("sdd")
                .joinPermission((short)0)
                .school("111")

                .examArrangement("SSS")
                .build();
        classService.updateClass(class1);

    }
}