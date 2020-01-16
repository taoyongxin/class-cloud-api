package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.domain.dto.QueryDto;
import com.scs.soft.cloud.api.domain.dto.SignDto;
import com.scs.soft.cloud.api.domain.entity.UserLogin;
import com.scs.soft.cloud.api.mapper.UserLoginMapper;
import com.scs.soft.cloud.api.service.RedisService;
import com.scs.soft.cloud.api.service.SmsService;
import com.scs.soft.cloud.api.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

@Service
@Slf4j
public class UserLoginServiceImpl implements UserLoginService {
    @Resource
    private UserLoginMapper userLoginMapper;
    @Resource
    private RedisService redisService;
    @Resource
    private SmsService smsService;

    @Override
    public Result login(SignDto signDto) {
        String mobile = signDto.getMobile();
        String password = signDto.getPassword();
        UserLogin userLogin;
        QueryDto queryDto = QueryDto.builder().equalsString(mobile).build();
        try {
            userLogin = userLoginMapper.findUserBy(queryDto);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if(userLogin != null){
            if (DigestUtils.md5Hex(password).equals(userLogin.getPassword())){
                String token = DigestUtils.sha3_256Hex(userLogin.getCode());
                redisService.set(mobile,token,60 * 24L);
                return Result.success(userLogin);
            }
            return Result.failure(ResultCode.USER_PASSWORD_ERROR);
        }
        return Result.failure(ResultCode.USER_ACCOUNT_ERROR);
    }
}
