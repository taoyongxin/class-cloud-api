package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.entity.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
                .purpose((short)1)
                .build();
        activityService.insertActivity(activity);
    }

    @Test
    void updateActivity() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime l1 = LocalDateTime.parse("2020-01-01 00:00:00",df);
        Activity activity = Activity.builder()
                .id(1)
                .name("C++")
                .purpose((short)1)
                .groupId(1)
                .status((short)1)
                .beginTime(l1)
                .endTime(l1)
                .build();
        activityService.updateActivity(activity);
    }


    @Test
    void deleteActivity() {
        activityService.deleteActivity(4,1);
    }
}