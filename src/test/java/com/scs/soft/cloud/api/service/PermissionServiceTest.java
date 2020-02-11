package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = CloudApiApplication.class)
class PermissionServiceTest {

    @Resource
    private PermissionService permissionService;
    @Test
    void getPermissionByParentId() {
        Result result = permissionService.getPermissionByParentId(0);
        System.out.println(result);
    }

    @Test
    void updateStyle() {
        Permission permission = Permission.builder()
                .id(2)
                .style((short)0)
                .build();
        Result result = permissionService.updateStyle(permission);
        System.out.println(result);
    }
}