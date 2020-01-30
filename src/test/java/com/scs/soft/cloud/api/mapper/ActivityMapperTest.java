package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.entity.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = CloudApiApplication.class)
class ActivityMapperTest {

    @Resource
    private ActivityMapper activityMapper;
    @Test
    void insert() throws SQLException {
        Activity activity = Activity.builder()
                .groupId(1)
                .userId(1)
                .name("头脑风暴")
                .type((short)1)
                .status((short)0)
                .theme("测试标题")
                .experience(3)
                .thumbnail("1.jpg")
                .use((short)1)
                .build();
        activityMapper.insert(activity);
    }
}