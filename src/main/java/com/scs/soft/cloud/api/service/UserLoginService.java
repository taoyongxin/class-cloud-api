package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.SignDto;
import com.scs.soft.cloud.api.domain.entity.UserLogin;

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
    /**
     * 手机短信验证快捷登录
     * @param signDto
     * @return
     */
    Result sign(SignDto signDto);

    /**
     * 根据手机号码修改密码
     * @param userLogin
     * @return
     */
    Result updateUserPassword(UserLogin userLogin);
}
