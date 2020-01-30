package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.entity.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;

@SpringBootTest(classes = CloudApiApplication.class)
class ActivityServiceTest {
    @Resource
    private ActivityService activityService;

    @Test
    void insertActivity() throws SQLException {
        Activity activity = Activity.builder()
                .groupId(1)
                .userId(1)
                .name("1111")
                .type((short)0)
                .thumbnail("1.jpg")
                .theme("13124")
                .experience(3)
                .use((short)1)
                .build();
        activityService.insertActivity(activity);
    }

}