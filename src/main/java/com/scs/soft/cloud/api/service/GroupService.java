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

    /**
     * 查询分组的活动数据情况
     * @param classId
     * @param userId
     * @return
     */
    Result getGroup(int classId,int userId);

    /**
     * 查询分组的资源数据情况
     * @param userId
     * @param classId
     * @return
     */
    Result getResource(int userId,int classId);

    /**
     * 修改分组展开或者收缩状态
     * @param group
     * @return
     */
    Result updateGroupStyle(Group group);
}
