package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;

/**
 * @author Tao
 */
public interface PermissionService {
    /**
     *通过父类权限码查询数据
     * @param parentId
     * @return
     */
    Result getPermissionByParentId(int parentId);
}
