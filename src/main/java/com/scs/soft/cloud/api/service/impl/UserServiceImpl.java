package com.scs.soft.cloud.api.service.impl;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.domain.dto.QueryDto;
import com.scs.soft.cloud.api.domain.dto.RegisterDto;
import com.scs.soft.cloud.api.domain.entity.User;
import com.scs.soft.cloud.api.domain.entity.UserLogin;
import com.scs.soft.cloud.api.domain.vo.UserIndexVo;
import com.scs.soft.cloud.api.mapper.UserLoginMapper;
import com.scs.soft.cloud.api.mapper.UserMapper;
import com.scs.soft.cloud.api.service.RedisService;
import com.scs.soft.cloud.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * @author Tao
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserLoginMapper userLoginMapper;
    @Resource
    private RedisService redisService;

    @Override
    public Result insertUser(RegisterDto registerDto) {
        String mobile = registerDto.getMobile();
        QueryDto queryDto = QueryDto.builder().equalsString(mobile).build();
        User user;
        UserLogin userLogin;
        try {
            user = userMapper.findUserByMobile(registerDto);
            userLogin = userLoginMapper.findUserBy(queryDto);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if(user == null){
            //数据不存在，新增用户数据到用户主表
            User saveUser = User.builder()
                    .mobile(registerDto.getMobile())
                    .name(registerDto.getName())
                    .jobNumber(registerDto.getJobNumber())
                    .experience(0)
                    .charisma(0)
                    .joinClassNumber(0)
                    .createClassNumber(0)
                    .resourceNumber(0)
                    .activityNumber(0)
                    .createTime(LocalDateTime.now())
                    .avatar("https://niit-student.oss-cn-beijing.aliyuncs.com/cloud/488fbe22-edb5-4148-b75e-f0447734bce1.png")
                    .profession(registerDto.getProfession())
                    .build();
            try {
                userMapper.insert(saveUser);
            } catch (SQLException e) {
                log.error(e.getMessage());
                return Result.failure(ResultCode.DATABASE_ERROR);
            }
            //使用Base64生成6为字符串的加密串
            String token = DigestUtils.sha3_256Hex(userLogin.getCode());
            //token存入redis，时效24h，客户端拿到token，变回登录状态；
            redisService.set(mobile,token,60*24L);
            UserIndexVo uvo = UserIndexVo.builder()
                    .id(userLogin.getId())
                    .mobile(mobile)
                    .password(userLogin.getPassword())
                    .code(token)
                    .status(userLogin.getStatus())
                    .profession(registerDto.getProfession())
                    .build();
            return Result.success(uvo);

        } else {
            return Result.failure(ResultCode.DATA_ALREADY_EXISTED);
        }

    }
}
