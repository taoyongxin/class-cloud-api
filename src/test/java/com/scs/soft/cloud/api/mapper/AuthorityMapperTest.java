package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.CloudApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = CloudApiApplication.class)
class AuthorityMapperTest {
    @Resource
    private AuthorityMapper authorityMapper;
    @Test
    void getAuthorityByFatherAuthority() throws SQLException {
        List<Map> authorityList =  authorityMapper.getAuthorityByFatherAuthority("0");
        authorityList.forEach(System.out::println);
    }
}