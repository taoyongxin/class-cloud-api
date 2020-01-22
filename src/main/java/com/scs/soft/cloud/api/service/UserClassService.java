package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.UserClass;

/**
 * @author Tao
 */
public interface UserClassService {
    /**
     * 用户加入班课
     * @param userClass
     * @return
     */
    Result insertUserClass(UserClass userClass);
}
