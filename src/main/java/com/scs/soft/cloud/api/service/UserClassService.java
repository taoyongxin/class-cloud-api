package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.PageDto;
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

    /**
     * 查询班课用户数据信息
     * @param classId
     * @return
     */
    Result selectUserClassByClassId(int classId);

    /**
     * 分页查询班课内用户成员数据信息
     * @param pageDto
     * @return
     */
    Result selectUserMessageByClassId(PageDto pageDto);
}
