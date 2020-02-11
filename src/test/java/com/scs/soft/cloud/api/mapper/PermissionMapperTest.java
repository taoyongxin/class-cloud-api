package com.scs.soft.cloud.api.mapper;


import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.entity.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = CloudApiApplication.class)
class PermissionMapperTest {
    @Resource
    private PermissionMapper permissionMapper;
    @Test
    void getPermissionByParentId() throws SQLException {
        List<Map> mapList = permissionMapper.getPermissionByParentId(0);
        System.out.println(mapList);
    }


    @Test
    void updateStyle() throws SQLException{
        Permission permission = permissionMapper.getPermissionById(2);
        permission.setStyle((short)1);
        permissionMapper.updateStyle(permission);
    }
}