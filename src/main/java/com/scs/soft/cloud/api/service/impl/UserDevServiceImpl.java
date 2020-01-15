package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.domain.dto.QueryDto;
import com.scs.soft.cloud.api.domain.dto.SignDto;
import com.scs.soft.cloud.api.domain.entity.UserDev;
import com.scs.soft.cloud.api.mapper.UserDevMapper;
import com.scs.soft.cloud.api.service.RedisService;
import com.scs.soft.cloud.api.service.UserDevService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author Tao
 */
@Service
@Slf4j
public class UserDevServiceImpl implements UserDevService {
    @Resource
    private UserDevMapper userDevMapper;
    @Resource
    private RedisService redisService;


    @Override
    public Result getAllUser() {
        return null;
    }

    @Override
    public Result login(SignDto signDto) {
        String mobile = signDto.getMobile();
        String password = signDto.getPassword();
        UserDev userDev;
        QueryDto queryDto = QueryDto.builder().equalsString(mobile).build();
        try {
            userDev = userDevMapper.findUserBy(queryDto);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if(userDev != null){
            if (DigestUtils.md5Hex(password).equals(userDev.getPassword())){
                String token = DigestUtils.sha3_256Hex(userDev.getCode());
                redisService.set(mobile,token,60 * 24L);
                return Result.success(userDev);
            }
            return Result.failure(ResultCode.USER_PASSWORD_ERROR);
        }
        return Result.failure(ResultCode.USER_ACCOUNT_ERROR);
    }
}
