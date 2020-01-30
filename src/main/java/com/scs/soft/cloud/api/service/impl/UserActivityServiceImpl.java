package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.domain.entity.UserActivity;
import com.scs.soft.cloud.api.mapper.CommonMapper;
import com.scs.soft.cloud.api.mapper.UserActivityMapper;
import com.scs.soft.cloud.api.service.UserActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * @author Tao
 */
@Slf4j
@Service
public class UserActivityServiceImpl implements UserActivityService {
    @Resource
    private UserActivityMapper userActivityMapper;
    @Resource
    private CommonMapper commonMapper;
    @Override
    public Result insertUserActivity(UserActivity userActivity) {
        UserActivity userActivity1 = UserActivity.builder()
                .userId(userActivity.getUserId())
                .activityId(userActivity.getActivityId())
                .joinTime(LocalDateTime.now())
                .acquisitionExperience(userActivity.getAcquisitionExperience())
                .joinStatus(userActivity.getJoinStatus())
                .build();
        try {
            commonMapper.alert("t_user_activity");
            userActivityMapper.insert(userActivity1);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        return Result.success();

    }
}
