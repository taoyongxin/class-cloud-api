package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.entity.UserClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = CloudApiApplication.class)
class UserClassMapperTest {
    @Resource
    private UserClassMapper userClassMapper;
    @Test
    void insert() throws SQLException {
        UserClass userClass = UserClass.builder()
                .userId(80)
                .roleId(1)
                .classId(50)
                .experience(0)
                .build();
        userClassMapper.insert(userClass);
    }
}