package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.domain.entity.Class;
import com.scs.soft.cloud.api.mapper.ClassMapper;
import com.scs.soft.cloud.api.mapper.CommonMapper;
import com.scs.soft.cloud.api.service.ClassService;
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
public class ClassServiceImpl implements ClassService {
    @Resource
    private ClassMapper classMapper;
    @Resource
    private CommonMapper commonMapper;
    @Override
    public Result getClassById(int id) {
        List<Map> mapList = null;
        try {
            mapList = classMapper.getClassByUserId(id);
        } catch (SQLException e) {
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        return Result.success(mapList);
    }

    @Override
    public Result getClassByCreatorId(int id) {
        List<Class> classList = null;
        try {
            classList = classMapper.getClassByCreatorId(id);
        } catch (SQLException e) {
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if (classList!=null && !classList.isEmpty()){
            return Result.success(classList);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result getClassByInvitationCode(int invitationCode) {
        Map<String,Object> class1 = null;
        try {
            class1 = classMapper.getClassByInvitationCode(invitationCode);
        } catch (SQLException e) {
            log.error("通过邀请码查询班课信息");
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if (class1!=null){
            return Result.success(class1);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

}
