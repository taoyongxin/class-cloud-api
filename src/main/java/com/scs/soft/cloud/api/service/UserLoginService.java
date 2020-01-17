package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.SignDto;

/**
 * @author Tao
 */
public interface UserLoginService {
    /**
     * 帐号密码登录
     * @param signDto
     * @return Result
     */
    Result login(SignDto signDto);

    /**
     * 注册账号
     * @param signDto
     * @return Result
     */
    Result register(SignDto signDto);
}
