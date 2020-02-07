package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.CloudApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;

@SpringBootTest(classes = CloudApiApplication.class)
class ResourceMapperTest {
    @Resource
    private ResourceMapper resourceMapper;

    @Test
    void getResourceByGroupId() throws SQLException {
        System.out.println(resourceMapper.getResourceByGroupId(1,1));
    }

    @Test
    void getResourceById() throws SQLException{
        System.out.println(resourceMapper.getResourceById(1));
    }
}