package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.domain.entity.Activity;
import com.scs.soft.cloud.api.mapper.ActivityMapper;
import com.scs.soft.cloud.api.mapper.CommonMapper;
import com.scs.soft.cloud.api.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author Tao
 */
@Service
@Slf4j
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private CommonMapper commonMapper;
    @Override
    public Result insertActivity(Activity activity) {
        Activity activity1 = Activity.builder()
                .groupId(activity.getGroupId())
                .userId(activity.getUserId())
                .name(activity.getName())
                .type(activity.getType())
                .status((short)0)
                .theme(activity.getTheme())
                .beginTime(activity.getBeginTime())
                .endTime(activity.getEndTime())
                .joinPersonNumber(activity.getJoinPersonNumber())
                .experience(activity.getExperience())
                .thumbnail(activity.getThumbnail())
                .use(activity.getUse())
                .build();
        try {
            commonMapper.alert("t_activity");
            activityMapper.insert(activity1);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        return Result.success();

    }
}
