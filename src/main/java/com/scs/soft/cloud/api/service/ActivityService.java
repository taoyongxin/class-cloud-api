package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.Activity;

/**
 * @author Tao
 */
public interface ActivityService {
    /**
     * 新增活动
     * @param activity
     * @return
     */
    Result insertActivity(Activity activity);

    /**
     * 修改活动信息
     * @param activity
     * @return
     */
    Result updateActivity(Activity activity);

    /**
     * 通过用户id和班课id查询活动
     * @param userId
     * @param classId
     * @return
     */
    Result getActivityByUserId(int userId,int classId);
}
