package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.CloudApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = CloudApiApplication.class)
class UserActivityMapperTest {

    @Resource
    private UserActivityMapper userActivityMapper;

    @Test
    void deleteUserActivity() throws SQLException {
        userActivityMapper.deleteUserActivity(4);
    }
}