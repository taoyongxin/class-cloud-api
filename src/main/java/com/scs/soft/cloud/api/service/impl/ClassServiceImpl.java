package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.mapper.ClassMapper;
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
}
