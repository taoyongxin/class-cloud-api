package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.entity.Group;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = CloudApiApplication.class)
class GroupMapperTest {

    @Resource
    private GroupMapper groupMapper;
    @Test
    void getGroupById() throws SQLException {
        System.out.println(groupMapper.getGroupById(1));
    }

    @Test
    void update() throws SQLException{
        Group group = groupMapper.getGroupById(5);
        group.setResourceNumber(1);
        groupMapper.update(group);
    }
}