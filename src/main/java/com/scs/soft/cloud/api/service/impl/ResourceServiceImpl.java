package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.domain.entity.Resource;
import com.scs.soft.cloud.api.mapper.ResourceMapper;
import com.scs.soft.cloud.api.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author Tao
 */
@Service
@Slf4j
public class ResourceServiceImpl implements ResourceService {
    @javax.annotation.Resource
    private ResourceMapper resourceMapper;
    @Override
    public Result updateStyle(Resource resource) {
        Resource resource1;
        try {
            resource1 = resourceMapper.getResourceById(resource.getId());
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if (resource1 != null){
            resource1.setStyle(resource.getStyle());
            try {
                resourceMapper.updateStyle(resource1);
            } catch (SQLException e) {
                log.error(e.getMessage());
                return Result.failure(ResultCode.DATABASE_ERROR);
            }
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        return Result.success();
    }
}
