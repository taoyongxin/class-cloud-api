package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.entity.UserDev;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest(classes = CloudApiApplication.class)
class UserDevMapperTest {

    @Resource
    private UserDevMapper userDevMapper;
    @Test
    void selectAll() throws SQLException {
        List<UserDev> users = userDevMapper.selectAll();
        users.forEach(System.out::println);
    }
}