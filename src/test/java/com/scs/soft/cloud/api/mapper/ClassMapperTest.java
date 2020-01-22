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
}