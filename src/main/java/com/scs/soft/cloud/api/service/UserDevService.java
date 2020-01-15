package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.SignDto;

/**
 * @author Tao
 */
public interface UserDevService {
    /**
     * 获取所有用户
     * @return Result
     */
    Result getAllUser();

    /**
     * 帐号密码登录
     * @param signDto
     * @return Result
     */
    Result login(SignDto signDto);
}
