package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.domain.dto.PageDto;
import com.scs.soft.cloud.api.domain.entity.UserClass;
import com.scs.soft.cloud.api.mapper.CommonMapper;
import com.scs.soft.cloud.api.mapper.UserClassMapper;
import com.scs.soft.cloud.api.service.UserClassService;
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
public class UserClassServiceImpl implements UserClassService {

    @Resource
    private CommonMapper commonMapper;
    @Resource
    private UserClassMapper userClassMapper;

    /**
     * 新增用户班课表 + 新增分组表信息
     * @param userClass
     * @return
     */
    @Override
    public Result insertUserClass(UserClass userClass) {
        UserClass userClass1 = UserClass.builder()
                .userId(userClass.getUserId())
                .roleId(userClass.getRoleId())
                .classId(userClass.getClassId())
                .experience(userClass.getExperience())
                .build();
        try {
            commonMapper.alert("t_user_class");
            userClassMapper.insert(userClass1);
        } catch (SQLException e) {
         log.error(e.getMessage());
         return Result.failure(ResultCode.DATABASE_ERROR);
        }
        return Result.success(userClass1);
    }

    @Override
    public Result selectUserClassByClassId(int classId) {
        List<Map> mapList = null;
        try {
            mapList = userClassMapper.getUserClassByClassId(classId);
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
    public Result selectUserMessageByClassId(PageDto pageDto) {
        List<Map> mapList = null;
        try {
            mapList = userClassMapper.getUserMessageByClassId(pageDto);
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
}
