package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.entity.UserActivity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = CloudApiApplication.class)
class UserActivityServiceTest {
    @Resource
    private UserActivityService userActivityService;

    @Test
    void insertUserActivity() {
        UserActivity userActivity = UserActivity.builder()
                .userId(1)
                .activityId(2)

                .acquisitionExperience(3)
                .joinStatus((short)0)
                .build();
        userActivityService.insertUserActivity(userActivity);
    }

}