package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.common.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = CloudApiApplication.class)
class ResourceServiceTest {
    @Resource
    private ResourceService resourceService;
    @Test
    void updateStyle() {
        com.scs.soft.cloud.api.domain.entity.Resource resource = com.scs.soft.cloud.api.domain.entity.Resource.builder()
                .id(1)
                .style((short)1)
                .build();
        Result result = resourceService.updateStyle(resource);
        System.out.println(result);
    }
}