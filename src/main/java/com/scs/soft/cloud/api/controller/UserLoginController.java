package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.SignDto;
import com.scs.soft.cloud.api.domain.entity.UserLogin;
import com.scs.soft.cloud.api.service.SmsService;
import com.scs.soft.cloud.api.service.UserLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Tao
 */
@RestController
@RequestMapping(value = "/api/user")
@Api(value = "UserLoginController",tags = {"用户登录模块接口"})
public class UserLoginController {
    @Resource
    private UserLoginService userLoginService;
    @Resource
    private SmsService smsService;

    @ApiOperation(value = "通过帐号密码登录",notes = "data为用户数据")
    @PostMapping(value = "/login")
    Result login(@RequestBody SignDto signDto){
        System.out.println(signDto);
        return userLoginService.login(signDto);
    }

    /**
     * 发送手机短信
     * @param signDto
     * @return
     */
    @ApiOperation(value = "通过手机号码发送短信验证码",notes = "")
    @PostMapping(value = "/sms")
    Result getSms(@RequestBody  SignDto signDto){
        return smsService.sendSms(signDto);
    }

    /**
     * 验证手机短信
     * @param signDto
     * @return
     */
    @ApiOperation(value = "判断手机号和验证码是否匹配",notes = "")
    @PostMapping(value = "/sms/check")
    Result checkSms(@RequestBody SignDto signDto){
        return smsService.checkSms(signDto);
    }

    /**
     * 注册账号
     * @param signDto
     * @return
     */
    @ApiOperation(value = "帐号注册（手机号码、密码、验证码）",notes = "")
    @PostMapping(value = "/register")
    Result register(@RequestBody SignDto signDto){
        return userLoginService.register(signDto);
    }

    /**
     * 手机短信快捷登录
     * @param signDto
     * @return
     */
    @ApiOperation(value = "通过手机短信验证登录",notes = "data为用户的数据")
    @PostMapping(value = "/sign")
    Result sign(@RequestBody SignDto signDto){
        return userLoginService.sign(signDto);
    }

    @ApiOperation(value = "通过手机号码修改密码",notes = "")
    @PutMapping(value = "/password")
    Result updatePassword(@RequestBody UserLogin userLogin){
        return userLoginService.updateUserPassword(userLogin);
    }
}

