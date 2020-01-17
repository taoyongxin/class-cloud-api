package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.dto.RegisterDto;
import com.scs.soft.cloud.api.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = CloudApiApplication.class)
class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    @Test
    void findUserByMobile() throws SQLException {
        RegisterDto registerDto = RegisterDto.builder().mobile("17826012341").build();
        User user = userMapper.findUserByMobile(registerDto);
        if (user != null){
            System.out.println(user);
        } else {
            System.out.println("未找到");
        }
    }
}