package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.RegisterDto;
import com.scs.soft.cloud.api.domain.entity.User;

/**
 * @author Tao
 */
public interface UserService {
    /**
     * 新增用户（数据主表）
     * @param registerDto
     * @return
     */
    Result insertUser(RegisterDto registerDto);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Result updateUser(User user);

    /**
     * 通过手机号码查找用户
     * @param user
     * @return
     */
    Result findUserByMobile(User user);
}
