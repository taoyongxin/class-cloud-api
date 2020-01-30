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
}
