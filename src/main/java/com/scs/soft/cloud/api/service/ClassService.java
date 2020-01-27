package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.entity.Class;

/**
 * @author Tao
 */
public interface ClassService {
    /**
     * 通过用户id查询所有班课数据
     * @param id
     * @return
     */
    Result getClassByUserId(int id);

    /**
     * 通过创建者id查询该用户创建的班课
     * @param id
     * @return
     */
    Result getClassByCreatorId(int id);

    /**
     * 通过班课id查询班课信息
     * @param id
     * @return
     */
    Result getClassById(int id);
    /**
     * 通过邀请码查询班课信息
     * @param invitationCode
     * @return
     */
    Result getClassByInvitationCode(int invitationCode);

    /**
     * 新增班课
     * @param class1
     * @return
     */
    Result insertClass(Class class1);

    /**
     * 修改班课信息
     * @param class1
     * @return
     */
    Result updateClass(Class class1);
}
