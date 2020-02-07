package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.Group;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest(classes = CloudApiApplication.class)
class GroupServiceTest {

    @Resource
    private GroupService groupService;
    @Test
    void insertGroup() {
        Group group = Group.builder()
                .name("ceshi")
                .classId(1)
                .build();
        Result result = groupService.insertGroup(group);
        System.out.println(result);
    }

    @Test
    void getGroupMessage() {
        Result result = groupService.getGroupMessage(1,2);
        System.out.println(result);
    }

    @Test
    void getGroup() {
        Result result  = groupService.getGroup(1,2);
        System.out.println(result);
    }

    @Test
    void getResource() {
        Result result  = groupService.getResource(1,1);
        System.out.println(result);
    }

    @Test
    void updateGroupStyle() {
        Group group = Group.builder()
                .id(21)
                .activityStyle((short)0)
                .build();
        Result result = groupService.updateGroupStyle(group);
        System.out.println(result);
    }
}