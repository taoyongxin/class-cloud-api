package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.UserActivity;

/**
 * @author Tao
 */
public interface UserActivityService {
    /**
     * 新增用户活动映射
     * @param userActivity
     * @return
     */
    Result insertUserActivity(UserActivity userActivity);
}
