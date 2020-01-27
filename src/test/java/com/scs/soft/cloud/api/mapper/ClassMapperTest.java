package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.entity.Class;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = CloudApiApplication.class)
class ClassMapperTest {

    @Resource
    private ClassMapper classMapper;
    @Test
    void getClassByUserId() throws SQLException {
        List<Map> classVoList = classMapper.getClassByUserId(1);
        System.out.println(classVoList);
    }

    @Test
    void getClassByCreatorId() throws SQLException{
        List<Class> classList = classMapper.getClassByCreatorId(4);
        System.out.println(classList);
    }

    @Test
    void getClassByInvitationCode() throws SQLException{
        Map<String, Object> map = classMapper.getClassByInvitationCode(411001);
        System.out.println(map);
    }

    @Test
    void insert() throws SQLException{
        Class class1 = Class.builder()
                .creatorId(90)
                .classType("11")
                .thumbnail("111")
                .name("111")
                .invitationCode(1551)
                .status((short)1)
                .resourceNumber(0)
                .activityNumber(0)
                .messageNumber(0)
                .memberNumber(0)
                .semester("2000-01-01")
                .build();
        classMapper.insert(class1);

    }

    @Test
    void getClassById() throws SQLException{
        Class class1 = classMapper.getClassById(1);
        System.out.println(class1);
    }

    @Test
    void update() throws SQLException{
        Class class1 = classMapper.getClassById(1);
        class1.setClassType("test");
        class1.setThumbnail("test.jpg");
        class1.setSchool("南工院");
        class1.setFaculty("testFaculty");
        classMapper.update(class1);

    }
}