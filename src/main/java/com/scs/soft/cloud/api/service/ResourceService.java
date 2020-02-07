package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.Resource;

/**
 * @author Tao
 */
public interface ResourceService {
    /**
     * 修改style字段
     * @param resource
     * @return
     */
    Result updateStyle(Resource resource);
}
