package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.RegisterDto;

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
}
