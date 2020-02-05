package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.dto.PageDto;
import com.scs.soft.cloud.api.domain.entity.UserClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    @Test
    void getUserClassByClassId() throws SQLException{
        List<Map> mapList = userClassMapper.getUserClassByClassId(100);
        System.out.println(mapList);
    }

    @Test
    void getUserMessageByClassId() throws SQLException{
        PageDto pageDto = PageDto.builder()
                .field(1)
                .currentPage(1)
                .pageSize(2)
                .build();
        List<Map> mapList = userClassMapper.getUserMessageByClassId(pageDto);
        System.out.println(mapList);

    }
}