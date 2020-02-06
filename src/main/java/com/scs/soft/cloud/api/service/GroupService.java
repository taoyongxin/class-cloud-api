package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.Group;

/**
 * @author Tao
 */
public interface GroupService {
    /**
     * 新增分组
     * @param group
     * @return
     */
    Result insertGroup(Group group);

    /**
     * 查询分组情况（对应用户班课）
     * @param classId
     * @param userId
     * @return
     */
    Result getGroupMessage(int classId,int userId);
}
