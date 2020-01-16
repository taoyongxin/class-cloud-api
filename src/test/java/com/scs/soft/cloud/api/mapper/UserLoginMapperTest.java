package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.dto.QueryDto;
import com.scs.soft.cloud.api.domain.entity.UserLogin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;

@SpringBootTest(classes = CloudApiApplication.class)
class UserLoginMapperTest {
    @Resource
    private UserLoginMapper userLoginMapper;
    @Test
    void findUserBy() throws SQLException {
        QueryDto queryDto = QueryDto.builder().equalsString("17826012341").build();
        UserLogin userLogin = userLoginMapper.findUserBy(queryDto);
        if(userLogin != null){
            System.out.println(userLogin);
        } else {
            System.out.println("not found");
        }
    }
}