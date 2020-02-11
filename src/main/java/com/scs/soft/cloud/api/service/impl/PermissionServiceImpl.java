package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.domain.entity.Permission;
import com.scs.soft.cloud.api.mapper.PermissionMapper;
import com.scs.soft.cloud.api.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Tao
 */
@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;
    @Override
    public Result getPermissionByParentId(int parentId) {
        List<Map> mapList;
        try {
            mapList = permissionMapper.getPermissionByParentId(parentId);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if (mapList!=null && !mapList.isEmpty()){
            return Result.success(mapList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result updateStyle(Permission permission) {
        Permission permission1;
        try {
            permission1 = permissionMapper.getPermissionById(permission.getId());
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if (permission1 != null){
           permission1.setStyle(permission.getStyle());
            try {
                permissionMapper.updateStyle(permission1);
            } catch (SQLException e) {
                log.error(e.getMessage());
                return Result.failure(ResultCode.DATABASE_ERROR);
            }
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        return Result.success();
    }
}
