package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.domain.dto.QueryDto;
import com.scs.soft.cloud.api.domain.dto.RegisterDto;
import com.scs.soft.cloud.api.domain.dto.SignDto;
import com.scs.soft.cloud.api.domain.entity.User;
import com.scs.soft.cloud.api.domain.entity.UserLogin;
import com.scs.soft.cloud.api.domain.vo.UserLoginVo;
import com.scs.soft.cloud.api.mapper.CommonMapper;
import com.scs.soft.cloud.api.mapper.UserLoginMapper;
import com.scs.soft.cloud.api.mapper.UserMapper;
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
    @Resource
    private UserMapper userMapper;

    @Override
    public Result login(SignDto signDto) {
        String mobile = signDto.getMobile();
        String password = signDto.getPassword();
        UserLogin userLogin;
        User user;
        QueryDto queryDto = QueryDto.builder().equalsString(mobile).build();
        RegisterDto registerDto = RegisterDto.builder().mobile(mobile).build();
        try {
            userLogin = userLoginMapper.findUserBy(queryDto);
            user = userMapper.findUserByMobile(registerDto);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if(userLogin != null){
            if (DigestUtils.md5Hex(password).equals(userLogin.getPassword())){
                if(userLogin.getStatus() == 1){
                    String token = DigestUtils.sha3_256Hex(userLogin.getCode());
                    redisService.set(mobile,token,60 * 24L);
                    UserLoginVo userLoginVo = UserLoginVo.builder()
                            .id(userLogin.getId())
                            .mobile(userLogin.getMobile())
                            .password(userLogin.getPassword())
                            .code(token)
                            .status(userLogin.getStatus())
                            .profession(user.getProfession())
                            .name(user.getName())
                            .avatar(user.getAvatar())
                            .build();
                    return Result.success(userLoginVo);
                }
                return Result.failure(ResultCode.USER_ACCOUNT_FORBIDDEN);
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
        return Result.failure(ResultCode.USER_VERIFY_CODE_ERROR);
    }

    /**
     * 手机号快捷登录
     * @param signDto
     * @return
     */
    @Override
    public Result sign(SignDto signDto) {
       String mobile = signDto.getMobile();
       QueryDto queryDto = QueryDto.builder().equalsString(mobile).build();
       UserLogin userLogin;
       User user;
       RegisterDto registerDto = RegisterDto.builder().mobile(mobile).build();
        try {
            userLogin = userLoginMapper.findUserBy(queryDto);
            user = userMapper.findUserByMobile(registerDto);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if(userLogin != null){
            //判断验证码是否正确
            Result result = smsService.checkSms(signDto);
            if(result.getCode() == 1){
                //验证码通过
                if (userLogin.getStatus() == 1){
                    String token = DigestUtils.sha3_256Hex(userLogin.getCode());
                    UserLogin ul = UserLogin.builder().id(userLogin.getId()).mobile(userLogin.getMobile()).password(userLogin.getPassword())
                            .code(token).status(userLogin.getStatus()).build();

                    UserLoginVo userLoginVo = UserLoginVo.builder()
                            .id(userLogin.getId())
                            .mobile(userLogin.getMobile())
                            .password(userLogin.getPassword())
                            .code(token)
                            .status(userLogin.getStatus())
                            .profession(user.getProfession())
                            .name(user.getName())
                            .avatar(user.getAvatar())
                            .build();

                    return Result.success(userLoginVo);
                } else {
                    return Result.failure(ResultCode.USER_ACCOUNT_FORBIDDEN);
                }
            } else {
                return Result.failure(ResultCode.USER_VERIFY_CODE_ERROR);
            }
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    /**
     * 通过手机号修改密码
     * @param userLogin
     * @return
     */
    @Override
    public Result updateUserPassword(UserLogin userLogin) {
        UserLogin userLogin1 = UserLogin.builder()
                .mobile(userLogin.getMobile())
                .password(DigestUtils.md5Hex(userLogin.getPassword()))
                .build();
        try {
            userLoginMapper.updatePassword(userLogin1);
        } catch (SQLException e) {
            log.error("修改密码出现异常");
        }
        return Result.success(userLogin1);
    }

    @Override
    public Result findUserBy(QueryDto queryDto) {
        UserLogin userLogin = null;
        try {
            userLogin = userLoginMapper.findUserBy(queryDto);
        } catch (SQLException e) {
            log.error("查询用户出现异常");
        }
        if(userLogin != null){
            if(userLogin.getStatus() == 1){
                return Result.success(userLogin);
            }else{
                return Result.failure(ResultCode.USER_ACCOUNT_FORBIDDEN);
            }
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
}
