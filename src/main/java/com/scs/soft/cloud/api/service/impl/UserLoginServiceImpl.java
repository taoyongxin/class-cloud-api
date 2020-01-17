package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.domain.dto.QueryDto;
import com.scs.soft.cloud.api.domain.dto.SignDto;
import com.scs.soft.cloud.api.domain.entity.UserLogin;
import com.scs.soft.cloud.api.mapper.CommonMapper;
import com.scs.soft.cloud.api.mapper.UserLoginMapper;
import com.scs.soft.cloud.api.service.RedisService;
import com.scs.soft.cloud.api.service.SmsService;
import com.scs.soft.cloud.api.service.UserLoginService;
import com.scs.soft.cloud.api.util.StringUtil;
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
public class UserLoginServiceImpl implements UserLoginService {
    @Resource
    private CommonMapper commonMapper;
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

    /**
     * 注册账号
     * @param signDto
     * @return
     */
    @Override
    public Result register(SignDto signDto) {
        //调用验证功能，判断验证码是否正确
        Result result = smsService.checkSms(signDto);
        if(result.getCode() ==1){
            String mobile = signDto.getMobile();
            String password = signDto.getPassword();
            QueryDto queryDto = QueryDto.builder().equalsString(mobile).build();
            UserLogin userLogin;
            try {
                userLogin = userLoginMapper.findUserBy(queryDto);
            } catch (SQLException e) {
                log.error(e.getMessage());
                return Result.failure(ResultCode.DATABASE_ERROR);
            }
            /*判断数据库中没有此手机号码，进行注册*/
            if(userLogin == null){
                String code = StringUtil.getRandomString();
                UserLogin saveUserLogin = UserLogin.builder()
                        .mobile(mobile)
                        .password(DigestUtils.md5Hex(password))
                        .code(code)
                        .status((short)1)
                        .build();
                try {
                    commonMapper.alert("t_user_login");
                    userLoginMapper.insert(saveUserLogin);
                } catch (SQLException e) {
                    log.error(e.getMessage());
                    return Result.failure(ResultCode.DATABASE_ERROR);
                }
                String token = DigestUtils.sha3_256Hex(code);
                redisService.set(mobile,token,60*24L);
                return Result.success(token);
            }else {
                return Result.failure(ResultCode.DATA_ALREADY_EXISTED);
            }
        }
        //验证未通过，返回实际的验证结果（错误，失效等）
        return result;
    }
}
